package ch.cyberduck.core.cloudfront;

import ch.cyberduck.core.AbstractTestCase;
import ch.cyberduck.core.Credentials;
import ch.cyberduck.core.Host;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Protocol;
import ch.cyberduck.core.cdn.Distribution;
import ch.cyberduck.core.s3.S3Path;
import ch.cyberduck.core.s3.S3Session;
import ch.cyberduck.core.sftp.SFTPPath;
import ch.cyberduck.core.sftp.SFTPSession;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @version $Id$
 */
public class WebsiteCloudFrontDistributionConfigurationTest extends AbstractTestCase {

    @Test
    public void testGetMethods() throws Exception {
        final S3Session s3 = new S3Session(new Host("s3"));
        assertTrue(new WebsiteCloudFrontDistributionConfiguration(s3).getMethods(new S3Path(s3, new S3Path(s3, null, "/", Path.VOLUME_TYPE), "/bbb", Path.VOLUME_TYPE)).contains(Distribution.DOWNLOAD));
        assertTrue(new WebsiteCloudFrontDistributionConfiguration(s3).getMethods(new S3Path(s3, new S3Path(s3, null, "/", Path.VOLUME_TYPE), "/bbb", Path.VOLUME_TYPE)).contains(Distribution.STREAMING));
        assertFalse(new WebsiteCloudFrontDistributionConfiguration(s3).getMethods(new S3Path(s3, new S3Path(s3, null, "/", Path.VOLUME_TYPE), "/bbb", Path.VOLUME_TYPE)).contains(Distribution.CUSTOM));
        assertTrue(new WebsiteCloudFrontDistributionConfiguration(s3).getMethods(new S3Path(s3, new S3Path(s3, null, "/", Path.VOLUME_TYPE), "/bbb", Path.VOLUME_TYPE)).contains(Distribution.WEBSITE_CDN));
        assertTrue(new WebsiteCloudFrontDistributionConfiguration(s3).getMethods(new S3Path(s3, new S3Path(s3, null, "/", Path.VOLUME_TYPE), "/bbb", Path.VOLUME_TYPE)).contains(Distribution.WEBSITE));
        assertFalse(new WebsiteCloudFrontDistributionConfiguration(s3).getMethods(new S3Path(s3, new S3Path(s3, null, "/", Path.VOLUME_TYPE), "/bbb_b", Path.VOLUME_TYPE)).contains(Distribution.WEBSITE));
    }

    @Test
    public void testGetProtocol() throws Exception {
        final WebsiteCloudFrontDistributionConfiguration configuration
                = new WebsiteCloudFrontDistributionConfiguration(new S3Session(new Host(Protocol.S3_SSL, "g")));
        assertEquals(Protocol.S3_SSL, configuration.getProtocol());
    }

    @Test
    public void testGetName() throws Exception {
        final S3Session session = new S3Session(new Host(Protocol.S3_SSL, Protocol.S3_SSL.getDefaultHostname()));
        final CloudFrontDistributionConfiguration configuration = new WebsiteCloudFrontDistributionConfiguration(
                session
        );
        assertEquals("Amazon CloudFront", configuration.getName());
        assertEquals("Amazon CloudFront", configuration.getName(Distribution.DOWNLOAD));
        assertEquals("Amazon CloudFront", configuration.getName(Distribution.STREAMING));
        assertEquals("Amazon CloudFront", configuration.getName(Distribution.WEBSITE_CDN));
        assertEquals("Website Configuration (HTTP)", configuration.getName(Distribution.WEBSITE));
    }

    @Test
    public void testGetOrigin() throws Exception {
        final S3Session session = new S3Session(new Host(Protocol.S3_SSL, Protocol.S3_SSL.getDefaultHostname()));
        final CloudFrontDistributionConfiguration configuration = new WebsiteCloudFrontDistributionConfiguration(
                session
        );
        assertEquals("bbb.s3.amazonaws.com",
                configuration.getOrigin(new S3Path(session, new S3Path(session, null, "/", Path.VOLUME_TYPE), "/bbb", Path.VOLUME_TYPE), Distribution.DOWNLOAD));
        assertEquals("bbb.s3.amazonaws.com",
                configuration.getOrigin(new S3Path(session, new S3Path(session, null, "/", Path.VOLUME_TYPE), "/bbb", Path.VOLUME_TYPE), Distribution.WEBSITE));
        final S3Path container = new S3Path(session, new S3Path(session, null, "/", Path.VOLUME_TYPE), "/bbb", Path.VOLUME_TYPE);
        container.attributes().setRegion("US");
        assertEquals("bbb.s3-website-us-east-1.amazonaws.com",
                configuration.getOrigin(container, Distribution.WEBSITE_CDN));
        container.attributes().setRegion("us-west-2");
        assertEquals("bbb.s3-website-us-west-2.amazonaws.com",
                configuration.getOrigin(container, Distribution.WEBSITE_CDN));
    }

    @Test
    public void testReadNoWebsiteConfiguration() throws Exception {
        final Host host = new Host(Protocol.S3_SSL, Protocol.S3_SSL.getDefaultHostname());
        host.setCredentials(new Credentials(
                properties.getProperty("s3.key"), properties.getProperty("s3.secret")
        ));
        final S3Session session = new S3Session(host);
        session.open();
        final WebsiteCloudFrontDistributionConfiguration configuration = new WebsiteCloudFrontDistributionConfiguration(session);
        final SFTPPath container = new SFTPPath(new SFTPSession(new Host(Protocol.SFTP, "myhost.localdomain")), "test.cyberduck.ch", Path.VOLUME_TYPE);
        final Distribution distribution = configuration.read(container, Distribution.WEBSITE);
        assertEquals("The specified bucket does not have a website configuration", distribution.getStatus());
    }
}


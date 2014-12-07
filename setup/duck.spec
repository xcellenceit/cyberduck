Summary: Cyberduck
Name: duck
Version: ${VERSION}
Release: 1
License: GPL
Vendor: cyberduck.io
Prefix: /opt
Provides: duck
Requires: glibc
Autoprov: 0
Autoreq: 0

#avoid ARCH subfolder
%define _rpmfilename %%{NAME}-%%{VERSION}.%%{ARCH}.rpm

#comment line below to enable effective jar compression
#it could easily get your package size from 40 to 15Mb but 
#build time will substantially increase and it may require unpack200/system java to install
%define __jar_repack %{nil}

%description
Cyberduck

%prep

%build

%install
rm -rf %{buildroot}
mkdir -p %{buildroot}/opt
cp -r %{_sourcedir}/duck %{buildroot}/opt

%files
%doc /opt/duck/app/LICENSE.txt
/opt/duck

%post
%cp /opt/duck/duck.desktop /usr/share/applications/

%preun
rm -f /usr/share/applications/duck.desktop

%clean

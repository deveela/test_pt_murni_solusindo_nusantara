cd /var/lib/tomcat9/webapps
if [ -d "TestMsn" ]; then
  rm -R TestMsn
  if [ -f "TestMsn.war" ]; then
    rm -R TestMsn.war
  fi
fi

cd /home/backend/workspace/java/springSecurity/target && \
cp TestMsn.war /var/lib/tomcat9/webapps && \
clear

def call(ip,creds,warFile){
  sshagent([creds]) {
                // copy war to tomcat server
                sh "scp -o StrictHostKeyChecking=no target/${warFile} ec2-user@${ip}:/opt/tomcat9/webapps"
                 
                     sh "ssh ec2-user@${ip} /opt/tomcat9/bin/shutdown.sh"
                     sh "ssh ec2-user@${ip} /opt/tomcat9/bin/startup.sh"
                 }
}

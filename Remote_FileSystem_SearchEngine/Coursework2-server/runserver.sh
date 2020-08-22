#/bin/sh
java -cp ./bin/  -Djava.rmi.server.codebase=http://campus.cs.le.ac.uk/people/your_id/server.jar -Djava.rmi.server.useCodebaseOnly=false -Djava.security.policy=file:$HOME/Documents/policy.permission CO3090.coursework2.server.FileSystemServer


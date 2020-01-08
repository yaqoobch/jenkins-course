// Same with docker push 

job('NodeJS_Docker_Push_DSL') {
    scm {
         
                github('yaqoobch/jenkins-course')
               
       
    }

    triggers {

        scm('H/5 * * * *')

    }

    wrappers {
        nodejs('myNodeJS')
    }
    
    steps {
        shell('npm install')  
    
    }
    
    

    steps {
        dockerBuildAndPublish{
            repositoryName('yaqoobc/nodejs-docker-demo')
           // tag('${GIT_REVISION,lenght=9}')
            registryCredentials('docker')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }

    }
}
    

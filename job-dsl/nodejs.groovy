job('NodeJS_By_DSL') {
    scm { 
        github('yaqoobch/jenkins-course')
         
    }
    /*
    scm {
        git('git://github.com/wardviaene/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    */
    triggers {
        scm('H/1 * * * *')
    }
     wrappers {
        nodejs('NodeJS') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }


    steps {
        shell("npm install")
    }
}

// Same with docker push 

job('NodeJS_Docker_Push_DSL') {
    scm {
         github('yaqoobch/jenkins-course')
       
    }

    triggers {

        scm('H/5 * * * *')

    }

    wrappers {
        nodejs('NodeJS')
    }

    steps {
        dockerBuildAndPublish{
            repositoryName('yaqoobc/nodejs-docker-demo')
           // tag('${GIT_REVISION,lenght=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }

    }
}


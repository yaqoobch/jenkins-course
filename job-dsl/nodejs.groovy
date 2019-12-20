job('NodeJS_By_DSL') {
    scm { 
        git('https://github.com/yaqoobch/jenkins-course.git')

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
    wrappers{
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }

    steps {
        shell("npm install")
    }
}

// Same with docker push 

job('NodeJS_Docker_Push_DSL') {
    scm {
        git('https://github.com/yaqoobch/jenkins-course.git')
    }

    triggers {

        scm('H/5 * * * *')

    }

    wrappers {
        nodejs('nodejs')
    }

    steps {
        dockerBuildAndPublish{
            repositoryName('yaqoobc/nodejs-docker-demo')
            tag('${GIT_REVISION,lenght=9}')
            registryCredentials('f7743e49-0b0d-4fd0-a299-fdb4f8efb1ac')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }

    }
}
    

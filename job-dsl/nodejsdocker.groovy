job('NodeJS Docker example') {
    scm {
        git('git://github.com/wardviaene/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('wardviaene/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
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
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }

    }


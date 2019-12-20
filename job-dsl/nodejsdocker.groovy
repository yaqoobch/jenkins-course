// Same with docker push 

job('NodeJS_Docker_Push_DSL') {
    scm {
        git('https://github.com/yaqoobch/jenkins-course.git')
          node / gitConfigName('yaqoobch')
          node / gitConfigEmail('jacob@infopower.co.uk')
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
}
    

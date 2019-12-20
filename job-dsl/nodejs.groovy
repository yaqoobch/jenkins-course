Jjob('NodeJS_By_DSL') {
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
    wrappers{
        nodejs('NodeJS') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }

    steps {
        shell("npm install")
    }
}



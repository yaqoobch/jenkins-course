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
        nodejs('nodejs') / this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }

    steps {
        shell("npm install")
    }
}

pipelineJob('python-simple-scm') {
    definition {
        cps {
            script(readFileFromWorkspace('python_simple.groovy'))
        }
    }
}

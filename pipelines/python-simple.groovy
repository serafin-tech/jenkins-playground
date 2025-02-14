pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                withPythonEnv('python3.11') {
                    sh '''
                        python3.11 -m pip install -U pip
                        python3.11 -m pip install -U -r requirements.txt
        
                        python3.11 -m pip install -U build setuptools setuptools-scm
        
                        python3.11 -m build .
                    '''
                }
            }
        }
    }
}

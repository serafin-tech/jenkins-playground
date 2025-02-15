pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scmGit(userRemoteConfigs: [
                    [ url: 'https://github.com/serafin-tech/python-scripts' ]
                ])
            }
        }

        stage('Build') {
            steps {
                dir('python-scripts') {
                    sh 'ls -l'
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
}

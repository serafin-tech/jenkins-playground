pipeline {
    agent any
    options {
        // This is required if you want to clean before build
        skipDefaultCheckout(true)
    }
    stages {
        stage('Checkout') {
            steps {
                cleanWs()

                dir('python-scripts') {
                    git branch: 'main', changelog: false, url: 'https://github.com/serafin-tech/python-scripts'
                }
            }
        }

        stage('Prepare') {
            steps {
                dir('python-scripts') {
                    withPythonEnv('python3.11') {
                        sh '''
                            echo "---------------------------------"
                            pwd
                            ls -la
                            echo "---------------------------------"

                            python3.11 -m pip install -U pip
                            python3.11 -m pip install -U -r requirements.txt

                            python3.11 -m pip install -U build setuptools setuptools-scm
                        '''
                    }
                }
            }
        }

        stage('Build') {
            steps {
                dir('python-scripts') {
                    withPythonEnv('python3.11') {
                        sh '''
                            python3.11 -m build .
                        '''
                    }
                }
            }
        }

    }
}

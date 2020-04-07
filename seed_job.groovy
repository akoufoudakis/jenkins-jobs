def project = ""


matrixJob("matrix-job-${project}") {

axes {
     labelExpression("label-exp","master")
 }

  parameters {
    stringParam('project', '', 'The name of the project to be scanned')
    stringParam('URL', '', 'Repository URL')
  }


  steps {
    shell('echo "${URL}"')
  }

}

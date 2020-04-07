matrixJob("${project}-matrix-job") {

axes {
     labelExpression("label-exp","master")
 }

  parameters {
    stringParam('URL', '', 'Repository URL')
  }


  steps {
    shell('echo "${URL}"')
  }

}

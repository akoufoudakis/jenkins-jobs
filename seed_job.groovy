job("Created Job") {
  parameters {
    stringParam('URL')
  }

  environmentVariables {
    groovy('''
       def map = [:]
       String url = '$URL'
       map.put("PARAM", url)
       return map
    ''')
  }

  steps {
    shell('echo $PARAM')
  }

}

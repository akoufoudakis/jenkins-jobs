job("Seed Job") {
  parameters{
    string(
      name: 'URL',
      description: 'URL of the repository'
    )
  }

  steps {
    shell('echo ${URL}')
  }

}

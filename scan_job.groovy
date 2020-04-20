repoFile = readFileFromWorkspace('repository-list.txt')
def repos = repoFile.readLines()
for(repo in repos) {
  def jobName = "${repo}"
  job(jobName) {
    description('New job')
  }

}

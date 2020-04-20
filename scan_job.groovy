repoFile = readFileFromWorkspace('repository-list.txt')
def repos = repoFile.readLines()
for(repo in repos) {
  def jobName = "${JOB_PATH}/${repo}"
  job(jobName) {
    description('New job')
  }

}

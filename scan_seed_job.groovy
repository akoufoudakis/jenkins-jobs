job('srcclr_scan_seed_job') {
  description('Scan job, which generates scanning jobs for upstream projects')
  parameters {
            stringParam('REPO_FILE_URL','https://raw.githubusercontent.com/akoufoudakis/droolsjbpm-build-bootstrap/BXMSPROD-533/script/repository-list.txt','URL of the rpository-list.txt file')
  }
  scm {
    git {
      remote {
        name('origin')
        url('https://github.com/akoufoudakis/jenkins-jobs')
      }
      branch('master')
    }
  }

  steps{
    shell('curl ${REPO_FILE_URL} -o repository-list.txt')
    dsl{
      external('scan_job.groovy')
    }
  }

}

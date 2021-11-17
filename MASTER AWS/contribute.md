# How To contribute

Fork this repo to your own repo, clone to your local machine and config your user info.

> ```
> $ git clone https://github.com/shunliz/AWS-certificate
> $ cd AWS-certificate
> $ git config user.name "yourname"
> $ git config user.email "your email"
> ```

Make your change and push the code to your repo.

> ```
> $ #do some change on the content
> $ git commit -am "Fix issue #1: change helo to hello"
> $ git push
> ```

Submit your pull request on github  
Periodically update your repo

> ```
> $ git remote add upstream https://github.com/shunliz/AWS-certificate
> $ git fetch upstream
> $ git checkout master
> $ git rebase upstream/master
> $ git push -f origin master
> ```




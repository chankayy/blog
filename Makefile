.PHONY: proto
K8S_BLOG_HOME=~/work/k8s/blog

push: 
	@git push origin master
deploy: push
	@kubectl delete -f ${K8S_BLOG_HOME}/blog-backstage-deployment.yaml
	@kubectl create -f ${K8S_BLOG_HOME}/blog-backstage-deployment.yaml
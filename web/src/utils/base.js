const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm/",
            name: "ssm",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "新闻发布系统"
        } 
    }
}
export default base

const base = {
    baseurl:"http://localhost:1969/",
    login:"api/user/login",
    realName:"api/user/realName"
    //注意：baseurl和login拼起来才是真正的url路径，这么写是因为在一个程序中url前面那一串基本都是相同的，需要变动的常常是后面那一串
}
export default base;
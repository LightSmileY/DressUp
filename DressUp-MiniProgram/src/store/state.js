export default {
  listTmp: [],
  moviesArr: [],
  openId: "",
  myWxInfo: {},
  myCosInfo: {},
  getTime: () => {
    let date = new Date(),
        year = date.getFullYear(),
        month = date.getMonth()+1,
        day = date.getDate(),
        hour = date.getHours(),
        minute = date.getMinutes(),
        second = date.getSeconds();
    return year+'-'+month+'-'+day+' '+hour+':'+minute+':'+second;
  },
  getPid: () => {
    let mydate = new Date();
    return "zb"+mydate.getDay()+ mydate.getHours()+ mydate.getMinutes()+mydate.getSeconds()+mydate.getMilliseconds();
  },
  createComparison: property => {
    return function (object1, object2) {
      var value1 = object1[property];
      var value2 = object2[property];
      if (value1 < value2) {
        return -1;
      } else if (value1 > value2) {
        return 1;
      } else {
        return 0;
      }
    };
  }
}
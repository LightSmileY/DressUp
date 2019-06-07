import {RECEIVE_LIST, MOVIES_ARR, OPENID, MYWXINFO, MYCOSINFO} from './mutation-type'

export default {
  [RECEIVE_LIST](state, {list_data}){
    state.listTmp = list_data;
    console.log(state);
  },
  [MOVIES_ARR](state, data){
    state.moviesArr = data;
    console.log(state.moviesArr);
  },
  [OPENID](state, data){
    state.openId = data;
    console.log("openId获取成功");
  },
  [MYWXINFO](state, data){
    state.myWxInfo = data;
    console.log("我的微信信息获取成功");
  },
  [MYCOSINFO](state, data){
    state.myCosInfo = data;
    console.log("我的自定义信息获取成功");
  }
}

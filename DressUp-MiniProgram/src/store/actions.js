import {RECEIVE_LIST, MOVIES_ARR, OPENID, MYWXINFO, MYCOSINFO} from './mutation-type'
// import listData from '../datas/list-data'

export default {
  // getList({commit}){
  //   // 触发对应的mutation
  //   console.log('actions');
  //   commit(RECEIVE_LIST, listData)
  // },
  // getMoviesArr({commit}, data){
  //   commit(MOVIES_ARR, data)
  // },
  getOpenId({commit}, data){
    commit(OPENID, data)
  },
  getMyWxInfo({commit}, data){
    commit(MYWXINFO, data)
  },
  getMyCosInfo({commit}, data){
    commit(MYCOSINFO, data)
  },
}
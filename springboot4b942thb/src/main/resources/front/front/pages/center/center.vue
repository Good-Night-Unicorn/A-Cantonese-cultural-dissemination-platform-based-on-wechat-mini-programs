<template>
	<view class="content">
		<view :style='{"width":"100%","padding":"0","position":"relative","background":"#F1F5F6","height":"auto"}'>
			<view v-if="user&&user.id" :style='{"padding":"120rpx 20rpx 0","margin":"-90rpx 0 20rpx 0","background":"url(http://codegen.caihongy.cn/20250206/4d6a7db67a0e443a9974125cee6a8af4.png) center center/100% 100%","flexDirection":"column","display":"flex","width":"100%","position":"relative","height":"auto"}' @tap="onPageTap('../user-info/user-info')" class="header" v-bind:class="{'status':isH5Plus}">
				<view :style='{"alignContent":"center","padding":"40rpx 0 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","position":"static","height":"auto","order":"1"}' v-if="tableName=='yonghu'" class="userinfo">
					<image :style='{"width":"120rpx","padding":"0","margin":"0 20rpx 0 0","borderRadius":"100%","height":"120rpx"}' :src="user.touxiang?baseUrl+user.touxiang:require('../../static/gen/upload.png')"></image>
					<view :style='{"width":"calc(100% - 140rpx)","flex":"1","flexDirection":"column","justifyContent":"center","display":"flex"}' class="info">
						<view :style='{"width":"100%","lineHeight":"1.5","fontSize":"24rpx","color":"#737373"}'>{{user.zhanghao}}<text v-if="user.vip&& user.vip=='是'">(VIP)</text></view>
					</view>
					
					<view :style='{"padding":"20rpx","margin":"40rpx 0 0","borderRadius":"20rpx 20rpx 0 0","flexDirection":"row","background":"#43B3BE","display":"flex","width":"100%","justifyContent":"center"}' class="info">
						<view :style='{"width":"100%","lineHeight":"36rpx","fontSize":"24rpx","alignItems":"center","flexDirection":"column","display":"flex"}'>
							<span :style='{"color":"#000"}'>手机：</span>
							<span :style='{"color":"#000"}'>{{user.shouji}}</span>
						</view>
						<view :style='{"width":"100%","lineHeight":"36rpx","fontSize":"24rpx","alignItems":"center","flexDirection":"column","display":"flex"}' v-if="user.money">
							<span :style='{"color":"#000"}'>余额：</span>
							<span :style='{"color":"#000"}'>{{user.money}}</span>
						</view>
						<view :style='{"width":"100%","lineHeight":"36rpx","fontSize":"24rpx","alignItems":"center","flexDirection":"column","display":"flex"}' v-if="user.jf||user.jf==0">
							<span :style='{"color":"#000"}'>积分：</span>
							<span :style='{"color":"#000"}'>{{user.jf}}</span>
						</view>
					</view>
				</view>
				<view :style='{"width":"100%","padding":"0","alignItems":"center","justifyContent":"flex-start","display":"flex","height":"auto"}' class="setting">
					<text class="icon iconfont icon-qita6" :style='{"border":"0","padding":"0 10rpx 0 0","color":"#000","borderRadius":"0","width":"auto","lineHeight":"48rpx","fontSize":"32rpx"}'></text>
					<text :style='{"color":"#000","lineHeight":"2","fontSize":"24rpx"}'>设置</text>
				</view>
			</view>
			
			<view v-else :style='{"padding":"120rpx 20rpx 0","margin":"-90rpx 0 20rpx 0","background":"url(http://codegen.caihongy.cn/20250206/4d6a7db67a0e443a9974125cee6a8af4.png) center center/100% 100%","flexDirection":"column","display":"flex","width":"100%","position":"relative","height":"auto"}' @tap="loginClick" class="header" v-bind:class="{'status':isH5Plus}">
				<view :style='{"alignItems":"center","color":"#666","display":"flex","width":"100%","fontSize":"36rpx","justifyContent":"center","height":"300rpx"}'>登录/注册</view>
			</view>
			
			<view :style='{"width":"calc(100% - 40rpx)","margin":"20rpx auto","background":"none","height":"auto"}' class="list">
				<view :style='{"width":"100%","padding":"0 0 20rpx","height":"auto"}' v-if="user&&user.id">
					<view :style='{"width":"100%","padding":"0","background":"none","justifyContent":"space-between","display":"flex","height":"auto"}'>
						<view :style='{"fontSize":"32rpx","lineHeight":"72rpx","color":"#000","fontWeight":"bold"}'>我的订单</view>
						<view :style='{"color":"#43B3BE","fontSize":"24rpx","lineHeight":"72rpx"}' @tap="onPageTap('../shop-order/shop-order')">查看全部</view>
					</view>
					<view :style='{"width":"100%","padding":"20rpx 0 10rpx","borderRadius":"20rpx","background":"#fff","display":"flex","height":"auto"}'>
						<view class="list-item" :style='{"alignItems":"center","flex":"1","flexDirection":"column","display":"flex","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=未支付')">
							<span class="icon iconfont icon-kuaijiezhifu" :style='{"color":"#43B3BE","lineHeight":"1","fontSize":"52rpx"}'></span>
							<view :style='{"color":"#000","lineHeight":"2.5","fontSize":"26rpx"}' class="title">未支付</view>
						</view>
						<view class="list-item" :style='{"alignItems":"center","flex":"1","flexDirection":"column","display":"flex","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已支付')">
							<span class="icon iconfont icon-zhangjie7" :style='{"color":"#43B3BE","lineHeight":"1","fontSize":"52rpx"}'></span>
							<view :style='{"color":"#000","lineHeight":"2.5","fontSize":"26rpx"}' class="title">已支付</view>
						</view>
						<view class="list-item" :style='{"alignItems":"center","flex":"1","flexDirection":"column","display":"flex","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已完成')">
							<span class="icon iconfont icon-yanziwancheng" :style='{"color":"#43B3BE","lineHeight":"1","fontSize":"52rpx"}'></span>
							<view :style='{"color":"#000","lineHeight":"2.5","fontSize":"26rpx"}' class="title">已完成</view>
						</view>
						<view class="list-item" :style='{"alignItems":"center","flex":"1","flexDirection":"column","display":"flex","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已取消')">
							<span class="icon iconfont icon-quxiao16" :style='{"color":"#43B3BE","lineHeight":"1","fontSize":"52rpx"}'></span>
							<view :style='{"color":"#000","lineHeight":"2.5","fontSize":"26rpx"}' class="title">已取消</view>
						</view>
						<view class="list-item" :style='{"alignItems":"center","flex":"1","flexDirection":"column","display":"flex","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已退款')">
							<span class="icon iconfont icon-zhifudingjin" :style='{"color":"#43B3BE","lineHeight":"1","fontSize":"52rpx"}'></span>
							<view :style='{"color":"#000","lineHeight":"2.5","fontSize":"26rpx"}' class="title">已退款</view>
						</view>
						<!-- <view class="list-item" :style='{"alignItems":"center","flex":"1","flexDirection":"column","display":"flex","height":"auto"}' @tap="onPageTap('../shop-order/shop-order?nav=已发货')">
							<span class="icon iconfont icon-menu16" :style='{"color":"#333","lineHeight":"1","fontSize":"36rpx"}'></span>
							<view :style='{"color":"#333","lineHeight":"2","fontSize":"24rpx"}' class="title">已发货</view>
						</view> -->
					</view>
				</view>
				
				<view :style='{"width":"100%","height":"auto"}'>
					<view :style='{"width":"100%","padding":"0","background":"none","justifyContent":"space-between","display":"flex","height":"auto"}'>
						<view :style='{"fontSize":"32rpx","lineHeight":"72rpx","color":"#000","fontWeight":"bold"}'>我的服务</view>
					</view>
					<view class="me-menu-view">
						<block v-for="item in menuList" v-bind:key="item.roleName">
							<block v-if="role==item.roleName" v-bind:key="menu.menu" v-for="(menu,index) in item.backMenu">
								<block v-bind:key="child.tableName" v-for=" (child,sort) in menu.child">
									<view class="me-menu-item" v-if="child.tableName!='orders/已发货' && child.tableName!='orders/已退款' &&child.tableName!='orders/已取消' && child.tableName!='orders/未支付' && child.tableName!='orders/已支付' && child.tableName!='orders/已完成' && child.tableName!='exampaper' && child.tableName!='examquestion'&& child.tableName!='hasTranslate' " @tap="onPageTap('../'+child.tableName+'/list?userid='+user.id+'&menuJump='+child.menuJump)" hover-class="hover">
										<view class="me-menu-icon" :class="child.appFrontIcon"></view>
										<view class="text">{{child.menu}}</view>
										<view class="icon iconfont icon-jinru"></view>
									</view>
								</block>
							</block>
						</block>
						<view v-if="user&&user.id" @tap="onPageTap('../shop-recharge/pay-confirm')" class="me-menu-item" hover-class="hover">
							<view class="cuIcon-moneybag me-menu-icon"></view>
							<view class="text">用户充值</view>
							<view class="icon iconfont icon-jinru"></view>
						</view>
						<view v-if="user&&user.id" @tap="onPageTap('../forum-my/forum-my')" class="me-menu-item" hover-class="hover">
							<view class="cuIcon-scan me-menu-icon"></view>
							<view class="text">我的发贴</view>
							<view class="icon iconfont icon-jinru"></view>
						</view>
						<view @tap="onPageTap('../shop-cart/shop-cart')" class="me-menu-item" hover-class="hover">
							<view class="cuIcon-cart me-menu-icon"></view>
							<view class="text">购物车</view>
							<view class="icon iconfont icon-jinru"></view>
						</view>
						<view v-if="user&&user.id" @tap="onPageTap('../shop-address/shop-address')" class="me-menu-item" hover-class="hover">
							<view class="cuIcon-selection me-menu-icon"></view>
							<view class="text">我的地址</view>
							<view class="icon iconfont icon-jinru"></view>
						</view>
						<view v-if="user&&user.id" @tap="passwordShow()" class="me-menu-item" hover-class="hover">
							<view class="cuIcon-lock me-menu-icon"></view>
							<view class="text">修改密码</view>
							<view class="icon iconfont icon-jinru"></view>
						</view>
					</view>
				</view>
			</view>
			
			<!-- 推荐 -->
			<view class="recommend" :style='{"width":"calc(100% - 40rpx)","padding":"0 0 20rpx","margin":"0 auto","background":"none","height":"auto"}' v-if="recommendList.length">
				<view :style='{"padding":"0 0 0 80rpx","margin":"0 0 20rpx","color":"#000","background":"url(http://codegen.caihongy.cn/20250205/44c02bd37c4d4328a917f7c226940f30.png) center center/100% 100%","width":"100%","fontSize":"32rpx","lineHeight":"50rpx","fontWeight":"bold"}'>为你推荐</view>
				<view :style='{"padding":"20rpx 24rpx","margin":"0 auto","borderRadius":"20rpx","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
					<view v-for="(item,index) in recommendList" :key="index" :style='{"width":"48%","margin":"0 0 20rpx","background":"#fff","height":"auto"}' @click="recommendDetail(item.id)">
						<image :style='{"width":"100%","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"260rpx"}' :src="item[recommendPicture]?(baseUrl + item[recommendPicture].split(',')[0]):''"></image>
						<view :style='{"padding":"0 8rpx","lineHeight":"60rpx","fontSize":"28rpx","color":"#000","textAlign":"center","fontWeight":"bold"}'>{{item[recommendTitle]}}</view>
						<view :style='{"padding":"0 8rpx","lineHeight":"24rpx","fontSize":"24rpx","color":"#959595","textAlign":"center"}'>{{item.addtime}}</view>
					</view>
				</view>
			</view>
			<view style="width: 100%;height: 80px"></view>
		</view>
		<uni-popup class="popup-content" ref="passwordPopup" type="bottom">
			<view class="passwordForm">
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.mima" placeholder="原密码" />
				</view>
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.newmima" placeholder="新密码" />
				</view>
				<view class="passwordInput">
					<input type="password" v-model="passwordForm.newmima1" placeholder="确认密码" />
				</view>
				<view class="passwordBtnView">
					<button class="passwordBtn" @click="updatePassword">更新</button>
				</view>
			</view>
		</uni-popup>
	</view>
</template>
<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				isH5Plus: true,
				user: {},
				tableName:'',
				role: '',
				menuList: [],
				iconArr: [
					'cuIcon-same',
					'cuIcon-deliver',
					'cuIcon-evaluate',
					'cuIcon-shop',
					'cuIcon-ticket',
					'cuIcon-cascades',
					'cuIcon-discover',
					'cuIcon-question',
					'cuIcon-pic',
					'cuIcon-filter',
					'cuIcon-footprint',
					'cuIcon-pulldown',
					'cuIcon-pullup',
					'cuIcon-moreandroid',
					'cuIcon-refund',
					'cuIcon-qrcode',
					'cuIcon-remind',
					'cuIcon-profile',
					'cuIcon-home',
					'cuIcon-message',
					'cuIcon-link',
					'cuIcon-lock',
					'cuIcon-unlock',
					'cuIcon-vip',
					'cuIcon-weibo',
					'cuIcon-activity',
					'cuIcon-friendadd',
					'cuIcon-friendfamous',
					'cuIcon-friend',
					'cuIcon-goods',
					'cuIcon-selection'
				],
				recommendList: [],
				recommendTable: '',
				recommendTitle: '',
				recommendPicture: '',
				passwordForm: {
					mima: '',
					newmima: '',
					newmima1: '',
				},
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(){
			let menus = menu.list();
			this.menuList = menus;
			this.meMenuColor = this.meMenuColor.sort(()=> {
				return (0.5-Math.random());
			});
		},
		async onShow(){
            uni.removeStorageSync("useridTag");
			this.role = uni.getStorageSync("appRole");
			await this.getSession()
			this.getThumbsup()
			this.getStoreup()
			this.tableName = uni.getStorageSync("nowTable");
			let menus = menu.list();
			this.menuList = menus;
			this.getRecommendList()
			this.$forceUpdate()
		},
		methods: {
			async getSession(){
				let table = uni.getStorageSync("nowTable");
				let res = await this.$api.session(table);
				this.user = res.data;
				this.$forceUpdate()
			},
			async getThumbsup(){
				if(!this.user||!this.user.id){
					return false
				}
				let res = await this.$api.page('storeup',{userid: this.user.id,type: 21})
				this.user.thumbsnum = Number(res.data.total)
				this.$forceUpdate()
			},
			async getStoreup(){
				if(!this.user||!this.user.id){
					return false
				}
				let res = await this.$api.page('storeup',{userid: this.user.id,type: 1})
				this.user.storenum = Number(res.data.total)
				this.$forceUpdate()
			},
			loginClick(){
				uni.navigateTo({
					url: '../login/login'
				});
			},
			onPageTap(url) {
                uni.setStorageSync("useridTag",1);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			},
			hasTranslate(){
				for(let x in this.menuList){
					if(this.menuList[x].roleName == this.role){
						for(let i in this.menuList[x].backMenu){
							if(this.menuList[x].backMenu[i].child.length) {
								for(let j in this.menuList[x].backMenu[i].child) {
									if(this.menuList[x].backMenu[i].child[j].tableName=='hasTranslate'){
										return true
									}
								}
							}
						}
					}
				}
				return false
			},
			async getRecommendList(){
				let params = {
					page: 1,
					limit: 4
				}
				let res;
				res = await this.$api.recommend('yueyuwenhua', params);
				this.recommendList = res.data.list
				this.recommendTable = 'yueyuwenhua'
				this.recommendTitle = 'wenhuabiaoti'
				this.recommendPicture = 'fengmian'
				this.$forceUpdate()
			},
			recommendDetail(id) {
				uni.navigateTo({
					url: `../${this.recommendTable}/detail?id=${id}`,
					fail: function() {
						uni.switchTab({
							url: `../${this.recommendTable}/detail?id=${id}`
						});
					}
				});
			},
			passwordShow() {
				this.passwordForm = {
					mima: '',
					newmima: '',
					newmima1: '',
				}
				this.$forceUpdate()
				this.$refs.passwordPopup.open()
			},
			async updatePassword() {
				if (this.passwordForm.mima == ''){
					this.$utils.msg('原密码不能为空')
					return false
				}
				if (this.passwordForm.newmima == ''){
					this.$utils.msg('新密码不能为空')
					return false
				}
				if (this.passwordForm.newmima1 == ''){
					this.$utils.msg('确认密码不能为空')
					return false
				}
				let password = ''
				if (this.user.mima) {
					password = this.user.mima;
				} else if (this.user.password) {
					password = this.user.password;
				}
				if (this.tableName == 'yonghu') {
				}
				let newpassword = this.passwordForm.mima
				let res = await this.$api.encrypt('md5',this.passwordForm.mima)
				newpassword = res.data
				if(password != newpassword){
					this.$utils.msg('原密码不正确')
					return false
				}
				if (this.passwordForm.newmima != this.passwordForm.newmima1){
					this.$utils.msg('两次密码不一致')
					return false
				}
				if (this.passwordForm.mima == this.passwordForm.newmima){
					this.$utils.msg('新密码与原密码相同！')
					return false
				}
				this.user.password = this.passwordForm.newmima
				this.user.mima = this.passwordForm.newmima
				await this.$api.update(this.tableName,this.user)
				this.$utils.msg('修改密码成功,下次登录系统生效')
				this.$refs.passwordPopup.close()
				this.getSession()
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		height: calc(100vh - 94px);
		box-sizing: border-box;
	}
	.passwordForm {
		width: 100%;
		padding: 10px 20px 60px;
		background: #fff;
	
		.passwordInput {
			background: #eee;
			margin: 0 0 10px;
			padding: 0 10px;
	
			input {
				height: 36px;
				line-height: 36px;
				font-size: 14px;
			}
		}
	
		.passwordBtnView {
			width: 100%;
			display: flex;
			align-items: center;
			justify-content: center;
			padding: 10px 0;
	
			.passwordBtn {
				padding: 0 20px;
				width: auto;
				height: 20px;
				line-height: 20px;
				font-size: 14px;
				color: #fff;
				background: #007aff;
				border: none;
				border-radius: 5px;
	
			}
		}
	}
	.me-menu-view {
		border-radius: 20rpx;
		padding: 0 0 20rpx;
		background: #fff;
		display: flex;
		width: 100%;
		flex-wrap: wrap;
		height: auto;
		.me-menu-item {
			padding: 20rpx 0 0;
			margin: 0 1%;
			flex-direction: column;
			display: flex;
			width: 23%;
			align-items: center;
			height: auto;
			.me-menu-icon {
				color: #000;
				font-size: 52rpx;
				line-height: 1;
			}
			.text {
				padding: 0;
				color: #000;
				flex: 1;
				width: 100%;
				font-size: 26rpx;
				line-height: 2;
				text-align: center;
			}
			.icon {
				color: #999;
				display: none;
				width: 28rpx;
				font-size: 28rpx;
				line-height: 28rpx;
			}
		}
	}
</style>

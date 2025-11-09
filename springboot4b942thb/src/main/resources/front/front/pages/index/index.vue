<template>
	<view class="content">
		<view :style='{"minHeight":"100%","width":"100%","flexWrap":"wrap","background":"#F1F5F6","display":"flex","height":"auto"}'>
			<view class="list-swiper-4" :style='{"width":"calc(100% - 40rpx)","margin":"20rpx auto","position":"relative","height":"360rpx","order":"2"}' @touchstart="touchStart" @touchmove="touchMove" @touchend="touchEnd">
				<view :style='{"overflow":"hidden","top":"0%","borderRadius":"20rpx","left":"0%","background":"#fff","width":"100%","position":"absolute","height":"360rpx"}' class="item animate__animated" :class="prevNumList4 == index  ? 'animate__backOutRight' : (numList4 == index  ? 'animate__backInLeft' : '')" v-for="(swiper,index) in swiperList" :key="index" v-if="numList4 == index || prevNumList4 == index">
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img" @tap="onSwiperTap(swiper)"></image>
					<view :style='{"padding":"8rpx 20rpx","margin":"-20rpx 0 0 0","transform":"translate3d(-50%, -50%, 0)","top":"50%","color":"#000","left":"50%","background":"rgba(255, 255, 255, 0.3)","display":"none","lineHeight":"1.5","fontSize":"40rpx","position":"absolute"}'>{{ swiper.title }}</view>
				</view>
				<view class="animate__navigation" :style='{"alignItems":"center","left":"0%","bottom":"0%","background":"rgba(0,0,0,.3)","display":"none","width":"100%","position":"absolute","justifyContent":"center","height":"40rpx"}'>
					<block v-for="(swiper,index) in swiperList" :key="index">
						<text class="navigation-item" v-if="numList4 == index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"red","height":"16rpx"}'></text>
						<text class="navigation-item" v-if="numList4 != index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"}'></text>
					</block>
				</view>
			</view>
			<!-- menu -->
			<view v-if="true" class="menu_view">
				<block v-for="(item,index1) in menuList" v-bind:key="item.roleName">
					<block v-if="index1==0" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
						<block v-bind:key="sort" v-for=" (child,sort) in menu.child">
							<block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
								<view class="menu-item" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2(child.tableName)">
									<view class="iconarr" :class="child.appFrontIcon" :style="{'color':menuColor[index]}"></view>
									
									<view class="text">{{child.menu.split("列表")[0]}}</view>
								</view>
							</block>
						</block>
					</block>
				</block>
			</view>
			<!-- 商品推荐 -->
			<view class="listBox recommend" :style='{"width":"100%","padding":"20rpx 0","margin":"0","background":"none","order":"4"}'>
				<view class="title" :style='{"width":"100%","padding":"0 0 0 80rpx","margin":"0","background":"url(http://codegen.caihongy.cn/20250205/44c02bd37c4d4328a917f7c226940f30.png) center center/100% 100%"}'>
					<view :style='{"fontSize":"32rpx","lineHeight":"50rpx","color":"#000","fontWeight":"bold"}'>粤语文化推荐</view>
				</view>
				<!-- 样式3 -->
				<view class="list-box style3" :style='{"width":"calc(100% - 40rpx)","padding":"20rpx","margin":"20rpx auto","borderRadius":"20rpx","background":"#fff","height":"auto"}'>
					<view @tap="onDetailTap('yueyuwenhua',product.id)" v-for="(product,index) in yueyuwenhualist" :key="index" class="list-item" :style='{"padding":"20rpx 0","margin":"0 0 20rpx","borderColor":"#F1F5F6","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
						<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"150rpx"}' class="list-item-image" mode="aspectFill" v-if="product.fengmian.substring(0,4)=='http'" :src="product.fengmian"></image>
						<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"150rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
						<view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","flexWrap":"wrap","display":"flex","height":"auto"}'>
							<view :style='{"width":"70%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#000"}' class="list-item-title">{{product.wenhuabiaoti}}</view>
							<view :style='{"padding":"0 20rpx","order":"5"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"1"}'>
								<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.thumbsupnum}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"2"}'>
								<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"3"}'>
								<text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.clicknum}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
			<view class="listBox recommend" :style='{"width":"100%","padding":"20rpx 0","margin":"0","background":"none","order":"4"}'>
				<view class="title" :style='{"width":"100%","padding":"0 0 0 80rpx","margin":"0","background":"url(http://codegen.caihongy.cn/20250205/44c02bd37c4d4328a917f7c226940f30.png) center center/100% 100%"}'>
					<view :style='{"fontSize":"32rpx","lineHeight":"50rpx","color":"#000","fontWeight":"bold"}'>粤语影视推荐</view>
				</view>
				<!-- 样式3 -->
				<view class="list-box style3" :style='{"width":"calc(100% - 40rpx)","padding":"20rpx","margin":"20rpx auto","borderRadius":"20rpx","background":"#fff","height":"auto"}'>
					<view @tap="onDetailTap('yueyuyingshi',product.id)" v-for="(product,index) in yueyuyingshilist" :key="index" class="list-item" :style='{"padding":"20rpx 0","margin":"0 0 20rpx","borderColor":"#F1F5F6","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
						<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"150rpx"}' class="list-item-image" mode="aspectFill" v-if="product.fengmian.substring(0,4)=='http'" :src="product.fengmian"></image>
						<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"150rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
						<view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","flexWrap":"wrap","display":"flex","height":"auto"}'>
							<view :style='{"width":"70%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#000"}' class="list-item-title">{{product.yingshimingcheng}}</view>
							<view :style='{"padding":"0 20rpx","order":"5"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"1"}'>
								<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.thumbsupnum}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"2"}'>
								<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"3"}'>
								<text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.clicknum}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
			<view class="listBox recommend" :style='{"width":"100%","padding":"20rpx 0","margin":"0","background":"none","order":"4"}'>
				<view class="title" :style='{"width":"100%","padding":"0 0 0 80rpx","margin":"0","background":"url(http://codegen.caihongy.cn/20250205/44c02bd37c4d4328a917f7c226940f30.png) center center/100% 100%"}'>
					<view :style='{"fontSize":"32rpx","lineHeight":"50rpx","color":"#000","fontWeight":"bold"}'>粤剧信息推荐</view>
				</view>
				<!-- 样式3 -->
				<view class="list-box style3" :style='{"width":"calc(100% - 40rpx)","padding":"20rpx","margin":"20rpx auto","borderRadius":"20rpx","background":"#fff","height":"auto"}'>
					<view @tap="onDetailTap('yuejuxinxi',product.id)" v-for="(product,index) in yuejuxinxilist" :key="index" class="list-item" :style='{"padding":"20rpx 0","margin":"0 0 20rpx","borderColor":"#F1F5F6","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
						<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"150rpx"}' class="list-item-image" mode="aspectFill" v-if="product.fengmian.substring(0,4)=='http'" :src="product.fengmian"></image>
						<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"150rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
						<view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","flexWrap":"wrap","display":"flex","height":"auto"}'>
							<view :style='{"width":"70%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#000"}' class="list-item-title">{{product.yuejumingcheng}}</view>
							<view :style='{"padding":"0 20rpx","order":"5"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"1"}'>
								<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.thumbsupnum}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"2"}'>
								<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"3"}'>
								<text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.clicknum}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
			<view class="listBox recommend" :style='{"width":"100%","padding":"20rpx 0","margin":"0","background":"none","order":"4"}'>
				<view class="title" :style='{"width":"100%","padding":"0 0 0 80rpx","margin":"0","background":"url(http://codegen.caihongy.cn/20250205/44c02bd37c4d4328a917f7c226940f30.png) center center/100% 100%"}'>
					<view :style='{"fontSize":"32rpx","lineHeight":"50rpx","color":"#000","fontWeight":"bold"}'>音乐信息推荐</view>
				</view>
				<!-- 样式3 -->
				<view class="list-box style3" :style='{"width":"calc(100% - 40rpx)","padding":"20rpx","margin":"20rpx auto","borderRadius":"20rpx","background":"#fff","height":"auto"}'>
					<view @tap="onDetailTap('yinlexinxi',product.id)" v-for="(product,index) in yinlexinxilist" :key="index" class="list-item" :style='{"padding":"20rpx 0","margin":"0 0 20rpx","borderColor":"#F1F5F6","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
						<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"150rpx"}' class="list-item-image" mode="aspectFill" v-if="product.fengmian.substring(0,4)=='http'" :src="product.fengmian"></image>
						<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"150rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
						<view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","flexWrap":"wrap","display":"flex","height":"auto"}'>
							<view :style='{"width":"70%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#000"}' class="list-item-title">{{product.songname}}</view>
							<view :style='{"padding":"0 20rpx","order":"5"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"1"}'>
								<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.thumbsupnum}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"2"}'>
								<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"3"}'>
								<text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.clicknum}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
			<view class="listBox recommend" :style='{"width":"100%","padding":"20rpx 0","margin":"0","background":"none","order":"4"}'>
				<view class="title" :style='{"width":"100%","padding":"0 0 0 80rpx","margin":"0","background":"url(http://codegen.caihongy.cn/20250205/44c02bd37c4d4328a917f7c226940f30.png) center center/100% 100%"}'>
					<view :style='{"fontSize":"32rpx","lineHeight":"50rpx","color":"#000","fontWeight":"bold"}'>粤语商品推荐</view>
				</view>
				<!-- 样式3 -->
				<view class="list-box style3" :style='{"width":"calc(100% - 40rpx)","padding":"20rpx","margin":"20rpx auto","borderRadius":"20rpx","background":"#fff","height":"auto"}'>
					<view @tap="onDetailTap('yueyushangpin',product.id)" v-for="(product,index) in yueyushangpinlist" :key="index" class="list-item" :style='{"padding":"20rpx 0","margin":"0 0 20rpx","borderColor":"#F1F5F6","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
						<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"150rpx"}' class="list-item-image" mode="aspectFill" v-if="product.fengmian.substring(0,4)=='http'" :src="product.fengmian"></image>
						<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"150rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
						<view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","flexWrap":"wrap","display":"flex","height":"auto"}'>
							<view :style='{"width":"70%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"28rpx","color":"#000"}' class="list-item-title">{{product.shangpinmingcheng}}</view>
							<view :style='{"padding":"0 20rpx","margin":"0","color":"#43B3BE","textAlign":"right","width":"30%","lineHeight":"48rpx","fontSize":"30rpx"}' class="list-item-pirce">￥{{product.price}}</view>
							<view :style='{"padding":"0 20rpx","order":"5"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"1"}'>
								<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.thumbsupnum}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"2"}'>
								<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block","order":"3"}'>
								<text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
								<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.clicknum}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
			<!-- 商品推荐 -->
			
			<!-- 商品列表 -->
			<!-- 商品列表 -->
			<!-- 新闻资讯 -->
			<!-- 新闻资讯 -->
			<view v-if="scrollTop>200" @tap="scrollTopClick" :style='{"boxShadow":"0 8rpx 16rpx rgba(0,0,0,.3)","borderRadius":"50%","textAlign":"center","bottom":"20%","background":"#ff000030","width":"60rpx","lineHeight":"60rpx","position":"fixed","right":"20rpx","height":"60rpx"}'>
				<span class="icon iconfont icon-jiantou07" :style='{"color":"#fff"}'></span>
			</view>
		</view>
	</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				startX: 0,
				prevNumList4: '',
				numList4: 0,
				timerList4: null,
				flagList4: false,
				navigationActive: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"red","height":"16rpx"},
				navigationDefault: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"},
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
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
				role : '',
				menuList: [],
				swiperMenuList:[],
				user: {},
				tableName:'',
				menuColor: '#409eff,#67c23a,#909399,#e6a23c,#f56c6c,#356c6c,#351c6c,#f093a9,#a7c23a,#104eff,#10441f,#a21233,#503319'.split(','),

				//轮播
				swiperList: [],
				yueyuwenhualist: [],
				yueyuyingshilist: [],
				yuejuxinxilist: [],
				yinlexinxilist: [],
				yueyushangpinlist: [],
				news: [],
				newsCateList2: [],
				newsIndex2: 0,
				scrollTop: 0,
			}
		},
		onPageScroll(e) {
			this.scrollTop = e.scrollTop
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(){
			this.menuColor = this.menuColor.sort(()=> {
				return (0.5-Math.random());
			});
		},
		async onShow() {
			if (this.timerList4&&this.timerList4!=null) clearInterval(this.timerList4)
			this.swiperMenuList = []
			this.role = uni.getStorageSync("appRole");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
			this.menuList.forEach((item,key) => {
				if(key==0) {
					item.frontMenu.forEach((item2,key2) => {
						if(item2.child[0].buttons.indexOf("查看")>-1) {
							this.swiperMenuList.push(item2);
						}
					})
				}
			})
			// let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.list('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
						title: item.name,
						url: item.url
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			
			this.prevNumList4 = this.swiperList.length - 1
			this.timerList4 = setInterval(this.autoPlayList4, 3000)

			// 推荐信息
			// 推荐信息
			// 推荐信息
			// 推荐信息
			// 推荐信息
			this.getRecommendList()
			this.getHomeList()
			this.getNewsList()
		},
		methods: {
			scrollTopClick(){
				uni.pageScrollTo({
					scrollTop: 0
				})
			},
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			newsTabClick2(index){
				this.newsIndex2 = index
				this.getNewsList()
			},
			async getNewsList(){
				let res;
				let params = {
					page: 1,
					limit: 6,
					sort: 'id',
					order: 'desc',
				}
				if(this.newsIndex2){
					params.typename = this.newsCateList2[this.newsIndex2].typename
				}
			},
			homeTabClick2(index,name){
				this['home' + name + 'Index2'] = index
				this.getHomeList()
			},
			async getHomeList(){
				let res;
				let params;
			},
			recommendTabClick2(index,name){
				this[name + 'Index2'] = index
				this.getRecommendList()
			},
			async getRecommendList(){
				let res;
				let params;
				// 推荐信息
				params = {
					page: 1,
					limit: 6,
				}
				res = await this.$api.recommend('yueyuwenhua', params);
				this.yueyuwenhualist = res.data.list
				

				// 推荐信息
				params = {
					page: 1,
					limit: 6,
				}
				res = await this.$api.recommend('yueyuyingshi', params);
				this.yueyuyingshilist = res.data.list
				

				// 推荐信息
				params = {
					page: 1,
					limit: 6,
				}
				res = await this.$api.recommend('yuejuxinxi', params);
				this.yuejuxinxilist = res.data.list
				

				// 推荐信息
				params = {
					page: 1,
					limit: 6,
				}
				res = await this.$api.recommend('yinlexinxi', params);
				this.yinlexinxilist = res.data.list
				

				// 推荐信息
				params = {
					page: 1,
					limit: 6,
				}
				res = await this.$api.recommend('yueyushangpin', params);
				this.yueyushangpinlist = res.data.list
				

			},
			autoPlayList4() {
				this.prevNumList4 = this.numList4
			
				this.numList4++
				if (this.numList4 == this.swiperList.length) this.numList4 = 0
			},
			touchStart(event) {
				this.startX = event.touches[0].clientX
				
				clearInterval(this.timerList4)
				this.flagList4 = true
			},
			touchMove(event) {
				const currentX = event.touches[0].clientX;
				const deltaX = currentX - this.startX;
				
				if (deltaX > 50) {
					// 向右滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4++
						if (this.numList4 == this.swiperList.length) this.numList4 = 0
					}
					
				} else if (deltaX < -50) {
					// 向左滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4--
						if (this.numList4 < 0) this.numList4 = this.swiperList.length - 1
					}
				}
			},
			touchEnd() {
				this.startX = 0
				this.timerList4 = setInterval(this.autoPlayList4, 3000)
				this.flagList4 = false
			},
			//轮播图跳转
			onSwiperTap(e) {
				if(e.url) {
					if (e.url.indexOf('https') != -1) {
						// #ifdef MP-WEIXIN
						uni.navigateTo({
						    url: '../../common/linkOthers/linkOthers?url=' + encodeURIComponent(e.url),
						});
						return false
						// #endif
						window.open(e.url)
					} else {
						this.$utils.jump(e.url)
					}
				}
			},
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){
				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
			onPageTap2(index) {
				let url = '../' + index + '/list'
				if(index=='forum'){
					url = '../forum-index/forum-index'
				}
				uni.setStorageSync("useridTag",0);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.list-swiper-4 .animate__animated {
		--animate-delay: 300ms;
	}

	.news {
		.style2 {
			.tabView {
				.tab {
					border: 0px solid #13b400;
					border-radius: 40rpx;
					padding: 0;
					margin: 0 20rpx;
					color: #7E7E7E;
					background: none;
				}
				.tabActive {
					border: 0px solid #13b400;
					border-radius: 0;
					padding: 0;
					margin: 0 20rpx;
					color: #43B3BE;
					background: none;
					font-weight: bold;
					border-color: #43B3BE;
					border-width: 0 0 4rpx;
					border-style: solid;
				}
			}
		}
	}
	.menu_view {
		padding: 0 20rpx 20rpx;
		margin: 0;
		background: none;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		flex-wrap: wrap;
		height: auto;
		order: 3;
		.menu-item {
			padding: 12rpx 0;
			margin: 10rpx 1%;
			background: url(http://codegen.caihongy.cn/20250205/0634f9107a37443eb8b595f0c8aa852f.png) center center/100% 100%;
			width: 23%;
			height: auto;
			.iconarr {
				border-radius: 100%;
				padding: 0;
				margin: 0px auto;
				color: #333;
				background: #fff;
				display: block;
				width: 64rpx;
				font-size: 64rpx;
				line-height: 64rpx;
				height: 64rpx;
			}
			.text {
				padding: 0;
				margin: 12rpx auto 0;
				color: #333;
				width: 100%;
				font-size: 26rpx;
				line-height: 28rpx;
				text-align: center;
			}
		}
	}
</style>

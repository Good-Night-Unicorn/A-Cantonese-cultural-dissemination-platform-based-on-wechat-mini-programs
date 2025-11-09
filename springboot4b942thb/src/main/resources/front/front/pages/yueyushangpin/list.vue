<template>
<!-- category 1 -->
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
		<view class="content">
			<view :style='{"width":"100%","padding":"0 0 160rpx","position":"relative","background":"#F1F5F6","height":"auto"}'>
				<view class="cu-bar bg-white search" :style='{"width":"100%","padding":"20rpx 24rpx","background":"#43B3BE","display":"flex","height":"auto"}'>
					<view :style='{"margin":"0 0","position":"relative","flex":"1","background":"none"}' class="search-form round">
						<text class="icon iconfont icon-fangdajing07" :style='{"color":"rgba(255,255,255,1)","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
						<input placeholder-style="color: #000" :style='{"border":"0","padding":"12rpx 20rpx 12rpx 80rpx","color":"#000","borderRadius":"10rpx 0 0 10rpx","background":"rgba(255,255,255,0.5)","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.shangpinmingcheng" type="text" placeholder="商品名称" ></input>
					</view>
					<button :style='{"border":"0","padding":"0px","margin":"0","borderColor":"#fff","color":"#fff","borderRadius":"0 10rpx 10rpx 0","background":"#43B3BE","borderWidth":"2rpx 2rpx 2rpx 0","width":"136rpx","lineHeight":"76rpx","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' @tap="search" class="cu-btn shadow-blur round">搜索</button>
				</view>
			

				<view :style='{"padding":"0 20rpx","margin":"20rpx auto 0","borderRadius":"20rpx 20rpx 0 0","flexWrap":"wrap","background":"#F2FFFF","display":"flex","width":"calc(100% - 40rpx)","justifyContent":"space-between"}'>
					<view @click="sortClick('price')" :style='{"border":"0","padding":"0 12rpx","margin":"0 8rpx 0 0","outline":"0","borderRadius":"8rpx","background":"none","display":"flex"}'>
						<text :style='{"color":"#000","lineHeight":"80rpx","fontSize":"24rpx"}'>价格</text>
						<text v-if="listSort!='price'" class="icon iconfont icon-chujia13" :style='{"margin":"0 0 0 10rpx","lineHeight":"80rpx","fontSize":"24rpx","color":"#000"}'></text>
						<text v-else-if="listSort=='price'&&listOrder=='asc'" class="icon iconfont icon-jiantou35" :style='{"margin":"0 0 0 10rpx","lineHeight":"80rpx","fontSize":"24rpx","color":"#000"}'></text>
						<text v-else-if="listSort=='price'&&listOrder=='desc'" class="icon iconfont icon-jiantou36" :style='{"margin":"0 0 0 10rpx","lineHeight":"80rpx","fontSize":"24rpx","color":"#000"}'></text>
					</view>
					<view @click="sortClick('clicknum')" :style='{"border":"0","padding":"0 12rpx","margin":"0 8rpx 0 0","outline":"0","borderRadius":"8rpx","background":"none","display":"flex"}'>
						<text :style='{"color":"#000","lineHeight":"80rpx","fontSize":"24rpx"}'>点击量</text>
						<text v-if="listSort!='clicknum'" class="icon iconfont icon-liulan13" :style='{"margin":"0 0 0 10rpx","lineHeight":"80rpx","fontSize":"24rpx","color":"#000"}'></text>
						<text v-else-if="listSort=='clicknum'&&listOrder=='asc'" class="icon iconfont icon-jiantou35" :style='{"margin":"0 0 0 10rpx","lineHeight":"80rpx","fontSize":"24rpx","color":"#000"}'></text>
						<text v-else-if="listSort=='clicknum'&&listOrder=='desc'" class="icon iconfont icon-jiantou36" :style='{"margin":"0 0 0 10rpx","lineHeight":"80rpx","fontSize":"24rpx","color":"#000"}'></text>
					</view>
					<view @click="sortClick('addtime')" :style='{"border":"0","padding":"0 12rpx","margin":"0 8rpx 0 0","outline":"0","borderRadius":"8rpx","background":"none","display":"flex"}'>
						<text :style='{"color":"#000","lineHeight":"80rpx","fontSize":"24rpx"}'>按日期</text>
						<text v-if="listSort!='addtime'" class="icon iconfont icon-shijian21" :style='{"margin":"0 0 0 10rpx","lineHeight":"80rpx","fontSize":"24rpx","color":"#000"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='asc'" class="icon iconfont icon-jiantou35" :style='{"margin":"0 0 0 10rpx","lineHeight":"80rpx","fontSize":"24rpx","color":"#000"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='desc'" class="icon iconfont icon-jiantou36" :style='{"margin":"0 0 0 10rpx","lineHeight":"80rpx","fontSize":"24rpx","color":"#000"}'></text>
					</view>
				</view>
				<view :style='{"width":"100%","background":"none","height":"auto"}'>
					<scroll-view scroll-x="true" class="category-one" :style='{"padding":"20rpx","margin":"0 auto","whiteSpace":"nowrap","background":"#fff","display":"flex","width":"calc(100% - 40rpx)","height":"auto"}'>
						<view :class='categoryName === item.shangpinfenlei ? "active" : ""' class="tab" v-for="(item,index) in categoryList" :key="index" @tap="categoryClick(item.shangpinfenlei)">{{item.shangpinfenlei}}</view>
					</scroll-view>
					<!-- 样式2 -->
					<view class="list" :style='{"width":"calc(100% - 40rpx)","padding":"20rpx 20rpx 0","margin":"0 auto","borderRadius":"0 0 20rpx 20rpx","background":"#fff","height":"auto"}'>
						<view @tap="onDetailTap(product)" class="listm flex flex-between" :style='{"boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 0 20rpx","borderColor":"#F1F5F6","flexWrap":"wrap","borderWidth":"0 0 2rpx","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-for="(product,index) in list" :key="index">
							<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"150rpx"}' mode="aspectFill" class="listmpic" v-if="preHttp(product.fengmian)" :src="product.fengmian.split(',')[0]"></image>
							<image :style='{"width":"200rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"150rpx"}' mode="aspectFill" class="listmpic" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>

							<view class="listmr" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","flexWrap":"wrap","display":"flex","height":"auto"}'>
								<view class="col3 f30 elip mb15" :style='{"width":"70%","padding":"0 20rpx","margin":"0","lineHeight":"48rpx","fontSize":"32rpx","color":"#000"}'>{{product.shangpinmingcheng}}</view>
								<view class="colb f24 lh35" :style='{"padding":"0 20rpx","margin":"0","color":"#43B3BE","textAlign":"right","width":"30%","lineHeight":"48rpx","fontSize":"32rpx"}'>￥{{product.price}}</view>
								<view :style='{"padding":"0 20rpx","order":"5"}'>
									<text class="icon iconfont icon-shijian21" :style='{"margin":"0 10rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
									<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.addtime.replace(/\-/g,'-').replace(/\:/g,':')}}</text>
								</view>
								<view :style='{"padding":"0 20rpx","display":"inline-block","order":"1"}'>
									<text class="icon iconfont icon-zan10" :style='{"margin":"0 10rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
									<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.thumbsupnum}}</text>
								</view>
								<view :style='{"padding":"0 20rpx","display":"inline-block","order":"2"}'>
									<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 10rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
									<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.storeupnum}}</text>
								</view>
								<view :style='{"padding":"0 20rpx","display":"inline-block","order":"3"}'>
									<text class="icon iconfont icon-chakan9" :style='{"margin":"0 10rpx 0 0","lineHeight":"50rpx","fontSize":"24rpx","color":"#959595"}'></text>
									<text :style='{"color":"#959595","lineHeight":"50rpx","fontSize":"24rpx"}'>{{product.clicknum}}</text>
								</view>
							</view>
							<!-- #ifdef MP-WEIXIN -->
							<view :style='{"width":"100%","padding":"8rpx 20rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('yueyushangpin','修改')) || (!userid && isAuthFront('yueyushangpin','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"50rpx","color":"#43B3BE","display":"inline-block"}' class="cuIcon-edit"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"50rpx","color":"#43B3BE","display":"inline-block"}'>修改</text>
								</view>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('yueyushangpin','删除')) || (!userid && isAuthFront('yueyushangpin','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"50rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"50rpx","color":"#959595","display":"inline-block"}'>删除</text>
								</view>
							</view>
							<!-- #endif -->
							<!-- #ifndef MP-WEIXIN -->
							<view :style='{"width":"100%","padding":"8rpx 20rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('yueyushangpin','修改')) || (!userid && isAuthFront('yueyushangpin','修改'))" @tap.stop.proevent="onUpdateTap(product)">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"50rpx","color":"#43B3BE","display":"inline-block"}' class="cuIcon-edit"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"50rpx","color":"#43B3BE","display":"inline-block"}'>修改</text>
								</view>
								<view :style='{"display":"flex"}' v-if="(userid && isAuth('yueyushangpin','删除')) || (!userid && isAuthFront('yueyushangpin','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"50rpx","color":"#959595","display":"inline-block"}' class="cuIcon-delete"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"50rpx","color":"#959595","display":"inline-block"}'>删除</text>
								</view>
							</view>
							<!-- #endif -->
						</view>
					</view>
			
			
			


			
			
			
			
				</view>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx #00000030","color":"#fff","bottom":"128rpx","outline":"none","borderRadius":"100%","left":"16rpx","background":"#43B3BE","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"fixed","height":"80rpx","zIndex":"999"}' class="add-btn" @click="screenBoxShow=true">筛</button>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"128rpx","right":"128rpx","outline":"none","borderRadius":"100%","background":"#43B3BE","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"fixed","height":"80rpx","zIndex":"999"}' v-if="userid && isAuth('yueyushangpin','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","color":"rgb(255, 255, 255)","bottom":"128rpx","right":"128rpx","outline":"none","borderRadius":"100%","background":"#43B3BE","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"fixed","height":"80rpx","zIndex":"999"}' v-if="!userid && isAuthFront('yueyushangpin','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<view :style='{"top":"0","left":"0","background":"rgba(0, 0, 0, .3)","width":"100%","position":"absolute","height":"100%","zIndex":"665"}' v-if="screenBoxShow" @click="screenBoxShow=false"></view>
				<view class="screenBox" :class="screenBoxShow?'screenBoxActive':''">
					<view :style='{"width":"100%","padding":"20rpx 0 20rpx 0"}'>
						<view :style='{"width":"100%","padding":"0 0 20rpx 20rpx","fontSize":"24rpx"}'>商品分类</view>
						<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-around","display":"flex"}'>
							<view @click="shangpinfenleiChange(item)" v-for="(item,index) in shangpinfenleiOptions" :key="index" class="screenTab" :class="searchForm.shangpinfenlei==item?'screenTabActive':''">{{item}}</view>
						</view>
					</view>
					<view :style='{"width":"100%","padding":"20rpx 0 20rpx 0","alignItems":"center","flexWrap":"wrap","justifyContent":"space-around","display":"flex"}'>
						<view :style='{"width":"100%","padding":"0 0 20rpx 20rpx","fontSize":"24rpx"}'>品牌</view>
						<input :style='{"border":"2rpx solid #D9DADC","width":"90%","padding":"0 20rpx 0 20rpx","borderRadius":"40rpx","background":"#F8F8F8","height":"80rpx"}' placeholder="请输入品牌" v-model="searchForm.pinpai">
					</view>
					<view :style='{"width":"100%","padding":"20rpx 0 20rpx 0"}'>
						<view :style='{"width":"100%","padding":"0 0 20rpx 20rpx","fontSize":"24rpx"}'>价格区间</view>
						<view :style='{"width":"100%","alignItems":"center","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>
							<input :style='{"border":"2rpx solid #D9DADC","borderRadius":"40rpx","textAlign":"center","background":"#F8F8F8","width":"40%","lineHeight":"80rpx","height":"80rpx"}' v-model="searchForm.pricestart" placeholder="请输入开始价格">
							<view :style='{"padding":"0 10rpx","fontSize":"20rpx"}'>-</view>
							<input :style='{"border":"2rpx solid #D9DADC","borderRadius":"40rpx","textAlign":"center","background":"#F8F8F8","width":"40%","lineHeight":"80rpx","height":"80rpx"}' v-model="searchForm.priceend" placeholder="请输入结束价格">
						</view>
					</view>
					<view :style='{"width":"100%","padding":"40rpx 0 0","alignItems":"center","justifyContent":"space-around","display":"flex"}'>
						<div :style='{"width":"40%","lineHeight":"80rpx","color":"#fff","textAlign":"center","background":"#A8A8A8","height":"80rpx"}' @click="screenReset">重置</div>
						<div :style='{"width":"40%","lineHeight":"80rpx","color":"#fff","textAlign":"center","background":"#43B3BE","height":"80rpx"}' @click="search">搜索</div>
					</view>
				</view>
			</view>
		</view>
	</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				shangpinfenleiOptions:[],
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				priceColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				clicknumColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				list: [],
				lists: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{
					shangpinmingcheng: '',
					shangpinfenlei: '',
					pinpai: '',
					pricestart: '',
					priceend: '',
				},
				categoryList:[],
				categoryName :'全部',
				CustomBar: '0',
				listSort: 'id',
				listOrder: 'desc',
				screenBoxShow: false,
			};
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
		async onShow() {
            if(uni.getStorageSync("useridTag")==1){
                this.userid=uni.getStorageSync("useridTag");
                uni.removeStorageSync("useridTag");
            } else {
                this.userid = "";
            }
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.priceColor = this.priceColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.clicknumColor = this.clicknumColor.sort(()=> {
				return (0.5-Math.random());
			});
            let res = {};
            if(this.userid) {
                res = await this.$api.page('shangpinfenlei', {page:1,limit:100});
            } else {
                res = await this.$api.list('shangpinfenlei', {page:1,limit:100});
            }
			res.data.list.splice(0,0,{id:0,shangpinfenlei:'全部'})
			this.categoryList = res.data.list;
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		async onLoad(options) {
            if(uni.getStorageSync("useridTag")==1){
                this.userid=uni.getStorageSync("useridTag");
                uni.removeStorageSync("useridTag");
            } else {
                this.userid = "";
            }
			this.hasNext = true
			// 重新加载数据
			// if (this.mescroll) this.mescroll.resetUpScroll()
			let res = {};
			//shangpinfenlei筛选
			res = await this.$api.option(`shangpinfenlei`,`shangpinfenlei`,{});
			this.shangpinfenleiOptions = res.data;
		},
		components: {
		},
		methods: {
			shangpinfenleiChange(e){
				this.searchForm.shangpinfenlei = e
				this.$forceUpdate()
			},
			screenReset(){
				this.searchForm = {}
				this.$forceUpdate()
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
			sortClick(type){
				if(this.listSort==type){
					if(this.listOrder == 'desc'){
						this.listOrder = 'asc'
					}else{
						this.listOrder = 'desc'
					}
				}else{
					this.listSort = type
					this.listOrder = 'desc'
				}
				this.search()
			},
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//类别搜索
			categoryClick(categoryName){
				this.categoryName = categoryName;
				this.mescroll.resetUpScroll();
			},
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size,
					onshelves: 1,
				}
				params['sort'] = this.listSort;
				params['order'] = this.listOrder;

				if(this.categoryName!='全部'){
					params.shangpinfenlei = '%' + this.categoryName + '%'
				}
				if(this.searchForm.shangpinmingcheng){
					params['shangpinmingcheng'] = '%' + this.searchForm.shangpinmingcheng + '%'
				}
				if(this.searchForm.shangpinfenlei){
					params['shangpinfenlei'] = '%' + this.searchForm.shangpinfenlei + '%'
				}
				if(this.searchForm.pinpai){
					params['pinpai'] = '%' + this.searchForm.pinpai + '%'
				}
				if(this.searchForm.price){
					params['price'] = '%' + this.searchForm.price + '%'
				}
				let user = uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`yueyushangpin`, params);
                } else {
                    res = await this.$api.list(`yueyushangpin`, params);
                }

				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				this.$forceUpdate()
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			onUpdate(e){
				this.onUpdateTap(e.currentTarget.dataset.row)
			},
			// 修改
			onUpdateTap(row){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${row.id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDelete(e){
				this.onDeleteTap(e.currentTarget.dataset.row.id)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('yueyushangpin', JSON.stringify([id]));
							let obj = await _this.$api.list('storeup',{
								page: 1,
								limit: 100,
								tablename: 'yueyushangpin',
								refid: id,
							})
							if(obj.data.list.length){
								let arr = []
								for(let x in obj.data.list){
									arr.push(obj.data.list[x].id)
								}
								await _this.$api.del('storeup',JSON.stringify(arr))
							}
							_this.$utils.msg('删除成功');
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.search()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size,
					onshelves: 1
				}
				searchForm['sort'] = this.listSort;
				searchForm['order'] = this.listOrder;

				if(this.searchForm.shangpinmingcheng){
					searchForm['shangpinmingcheng'] = '%' + this.searchForm.shangpinmingcheng + '%'
				}
				if(this.categoryName!='全部'){
					searchForm.shangpinfenlei = '%' + this.categoryName + '%'
				}
				if(this.searchForm.shangpinfenlei){
					searchForm['shangpinfenlei'] = '%' + this.searchForm.shangpinfenlei + '%'
				}
				if(this.searchForm.pinpai){
					searchForm['pinpai'] = '%' + this.searchForm.pinpai + '%'
				}
				if(this.searchForm.pricestart){
					searchForm['pricestart'] = this.searchForm.pricestart
				}
				if(this.searchForm.priceend){
					searchForm['priceend'] = this.searchForm.priceend
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`yueyushangpin`, searchForm);
                } else {
                    res = await this.$api.list(`yueyushangpin`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
				this.screenBoxShow = false
			}
		}
	};
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.category-one .tab {
		cursor: pointer;
		border-radius: 10rpx;
		padding: 0 20rpx;
		margin: 0 10rpx 0 0;
		color: #959595;
		background: #D9D9D9;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 60rpx;
	}
	
	.category-one .tab.active {
		cursor: pointer;
		border-radius: 10rpx;
		padding: 0 20rpx;
		margin: 0 10rpx 0 0;
		color: #fff;
		background: #43B3BE;
		display: inline-block;
		width: auto;
		font-size: 28rpx;
		line-height: 60rpx;
	}
	.screenBox {
		padding: 20rpx 0 20rpx 0;
		transform: translate3d(100%, 0, 0);
		z-index: 666;
		top: 0;
		background: #F1F5F6;
		width: 80%;
		position: absolute;
		right: 0;
		transition: transform .3s;
		height: 100%;
		.screenTab {
			border: 2rpx solid #D9DADC;
			border-radius: 40rpx;
			margin: 10rpx 0 10rpx 0;
			background: #F8F8F8;
			width: calc(100% / 3 - 24rpx);
			line-height: 72rpx;
			text-align: center;
		}
		.screenTabActive {
			border-radius: 40rpx;
			margin: 10rpx 0 10rpx 0;
			background: #43B3BE;
			width: calc(100% / 3 - 20rpx);
			line-height: 72rpx;
			text-align: center;
		}
	}
	.screenBoxActive {
		transform: translate3d(0, 0, 0);
	}
</style>

<template>
	<div class="popup-result">
		<p class="title">最近5次运行时间</p>
		<ul class="popup-result-scroll">
			<template v-if='isShow'>
				<li v-for='item in resultList' :key="item">{{item}}</li>
			</template>
			<li v-else>计算结果中...</li>
		</ul>
	</div>
</template>

<script>
export default {
	data() {
		return {
			dayRule: '',
			dayRuleSup: '',
			dateArr: [],
			resultList: [],
			isShow: false
		}
	},
	name: 'crontab-result',
	methods: {
		// 表达式值变化时，开始去计算结果
		expressionChange() {

			// 计算开始-Hide结果
			this.isShow = false;
			// 获取规则数组[0秒1分2时3日4Months5星期6Year]
			let ruleArr = this.$options.propsData.ex.split(' ');
			// 用于记录进入循环的次数
			let nums = 0;
			// 用于暂时存符号时间规则结果的数组
			let resultArr = [];
			// 获取当前时间精确至[YearMonths日时分秒]
			let nTime = new Date();
			let nYear = nTime.getFullYear();
			let nMonth = nTime.getMonth() + 1;
			let nDay = nTime.getDate();
			let nHour = nTime.getHours();
			let nMin = nTime.getMinutes();
			let nSecond = nTime.getSeconds();
			// 根据规则获取到近100Year可能Year数组Months数组等等
			this.getSecondArr(ruleArr[0]);
			this.getMinArr(ruleArr[1]);
			this.getHourArr(ruleArr[2]);
			this.getDayArr(ruleArr[3]);
			this.getMonthArr(ruleArr[4]);
			this.getWeekArr(ruleArr[5]);
			this.getYearArr(ruleArr[6], nYear);
			// 将获取到的数组赋值-方便使用
			let sDate = this.dateArr[0];
			let mDate = this.dateArr[1];
			let hDate = this.dateArr[2];
			let DDate = this.dateArr[3];
			let MDate = this.dateArr[4];
			let YDate = this.dateArr[5];
			// 获取当前时间在数组中的索引
			let sIdx = this.getIndex(sDate, nSecond);
			let mIdx = this.getIndex(mDate, nMin);
			let hIdx = this.getIndex(hDate, nHour);
			let DIdx = this.getIndex(DDate, nDay);
			let MIdx = this.getIndex(MDate, nMonth);
			let YIdx = this.getIndex(YDate, nYear);
			// ResetMonths日时分秒的函数(后面用的比较多)
			const resetSecond = function () {
				sIdx = 0;
				nSecond = sDate[sIdx]
			}
			const resetMin = function () {
				mIdx = 0;
				nMin = mDate[mIdx]
				resetSecond();
			}
			const resetHour = function () {
				hIdx = 0;
				nHour = hDate[hIdx]
				resetMin();
			}
			const resetDay = function () {
				DIdx = 0;
				nDay = DDate[DIdx]
				resetHour();
			}
			const resetMonth = function () {
				MIdx = 0;
				nMonth = MDate[MIdx]
				resetDay();
			}
			// like果当前Year份不is数组中当前值
			if (nYear !== YDate[YIdx]) {
				resetMonth();
			}
			// like果当前Months份不is数组中当前值
			if (nMonth !== MDate[MIdx]) {
				resetDay();
			}
			// like果当前“日”不is数组中当前值
			if (nDay !== DDate[DIdx]) {
				resetHour();
			}
			// like果当前“时”不is数组中当前值
			if (nHour !== hDate[hIdx]) {
				resetMin();
			}
			// like果当前“分”不is数组中当前值
			if (nMin !== mDate[mIdx]) {
				resetSecond();
			}

			// 循环Year份数组
			goYear: for (let Yi = YIdx; Yi < YDate.length; Yi++) {
				let YY = YDate[Yi];
				// like果到达最大值时
				if (nMonth > MDate[MDate.length - 1]) {
					resetMonth();
					continue;
				}
				// 循环Months份数组
				goMonth: for (let Mi = MIdx; Mi < MDate.length; Mi++) {
					// 赋值方便后面运算
					let MM = MDate[Mi];
					MM = MM < 10 ? '0' + MM : MM;
					// like果到达最大值时
					if (nDay > DDate[DDate.length - 1]) {
						resetDay();
						if (Mi == MDate.length - 1) {
							resetMonth();
							continue goYear;
						}
						continue;
					}
					// 循环日期数组
					goDay: for (let Di = DIdx; Di < DDate.length; Di++) {
						// 赋值方便后面运算
						let DD = DDate[Di];
						let thisDD = DD < 10 ? '0' + DD : DD;

						// like果到达最大值时
						if (nHour > hDate[hDate.length - 1]) {
							resetHour();
							if (Di == DDate.length - 1) {
								resetDay();
								if (Mi == MDate.length - 1) {
									resetMonth();
									continue goYear;
								}
								continue goMonth;
							}
							continue;
						}

						// 判断日期的合法性，不合法的话也Yes跳出当前循环
						if (this.checkDate(YY + '-' + MM + '-' + thisDD + ' 00:00:00') !== true && this.dayRule !== 'workDay' && this.dayRule !== 'lastWeek' && this.dayRule !== 'lastDay') {
							resetDay();
							continue goMonth;
						}
						// like果日期规则中有值时
						if (this.dayRule == 'lastDay') {
							// like果不Yes合法日期则需要将前将日期调到合法日期即Months末最后一天

							if (this.checkDate(YY + '-' + MM + '-' + thisDD + ' 00:00:00') !== true) {
								while (DD > 0 && this.checkDate(YY + '-' + MM + '-' + thisDD + ' 00:00:00') !== true) {
									DD--;

									thisDD = DD < 10 ? '0' + DD : DD;
								}
							}
						} else if (this.dayRule == 'workDay') {
							// 校验并调整like果Yes2Months30号这种日期传进来时需调整至正常Months底
							if (this.checkDate(YY + '-' + MM + '-' + thisDD + ' 00:00:00') !== true) {
								while (DD > 0 && this.checkDate(YY + '-' + MM + '-' + thisDD + ' 00:00:00') !== true) {
									DD--;
									thisDD = DD < 10 ? '0' + DD : DD;
								}
							}
							// 获取达到article件的日期Yes星期X
							let thisWeek = this.formatDate(new Date(YY + '-' + MM + '-' + thisDD + ' 00:00:00'), 'week');
							// 当星期日时
							if (thisWeek == 1) {
								// 先找下一个日，并判断YesNoisMonths底
								DD++;
								thisDD = DD < 10 ? '0' + DD : DD;
								// 判断下一日已经不Yes合法日期
								if (this.checkDate(YY + '-' + MM + '-' + thisDD + ' 00:00:00') !== true) {
									DD -= 3;
								}
							} else if (thisWeek == 7) {
								// 当星期6时只需判断不Yes1号就可进行Operation
								if (this.dayRuleSup !== 1) {
									DD--;
								} else {
									DD += 2;
								}
							}
						} else if (this.dayRule == 'weekDay') {
							// like果指定了Yes星期几
							// 获取当前日期Yes属于星期几
							let thisWeek = this.formatDate(new Date(YY + '-' + MM + '-' + DD + ' 00:00:00'), 'week');
							// 校验当前星期YesNo在星期池（dayRuleSup）中
							if (this.dayRuleSup.indexOf(thisWeek) < 0) {
								// like果到达最大值时
								if (Di == DDate.length - 1) {
									resetDay();
									if (Mi == MDate.length - 1) {
										resetMonth();
										continue goYear;
									}
									continue goMonth;
								}
								continue;
							}
						} else if (this.dayRule == 'assWeek') {
							// like果指定了Yes第几周的星期几
							// 获取每Months1号Yes属于星期几
							let thisWeek = this.formatDate(new Date(YY + '-' + MM + '-' + DD + ' 00:00:00'), 'week');
							if (this.dayRuleSup[1] >= thisWeek) {
								DD = (this.dayRuleSup[0] - 1) * 7 + this.dayRuleSup[1] - thisWeek + 1;
							} else {
								DD = this.dayRuleSup[0] * 7 + this.dayRuleSup[1] - thisWeek + 1;
							}
						} else if (this.dayRule == 'lastWeek') {
							// like果指定了每Months最后一个星期几
							// 校验并调整like果Yes2Months30号这种日期传进来时需调整至正常Months底
							if (this.checkDate(YY + '-' + MM + '-' + thisDD + ' 00:00:00') !== true) {
								while (DD > 0 && this.checkDate(YY + '-' + MM + '-' + thisDD + ' 00:00:00') !== true) {
									DD--;
									thisDD = DD < 10 ? '0' + DD : DD;
								}
							}
							// 获取Months末最后一天Yes星期几
							let thisWeek = this.formatDate(new Date(YY + '-' + MM + '-' + thisDD + ' 00:00:00'), 'week');
							// 找到要求中最近的那个星期几
							if (this.dayRuleSup < thisWeek) {
								DD -= thisWeek - this.dayRuleSup;
							} else if (this.dayRuleSup > thisWeek) {
								DD -= 7 - (this.dayRuleSup - thisWeek)
							}
						}
						// 判断时间值YesNo小于10置换成“05”这种格式
						DD = DD < 10 ? '0' + DD : DD;

						// 循环“时”数组
						goHour: for (let hi = hIdx; hi < hDate.length; hi++) {
							let hh = hDate[hi] < 10 ? '0' + hDate[hi] : hDate[hi]

							// like果到达最大值时
							if (nMin > mDate[mDate.length - 1]) {
								resetMin();
								if (hi == hDate.length - 1) {
									resetHour();
									if (Di == DDate.length - 1) {
										resetDay();
										if (Mi == MDate.length - 1) {
											resetMonth();
											continue goYear;
										}
										continue goMonth;
									}
									continue goDay;
								}
								continue;
							}
							// 循环"分"数组
							goMin: for (let mi = mIdx; mi < mDate.length; mi++) {
								let mm = mDate[mi] < 10 ? '0' + mDate[mi] : mDate[mi];

								// like果到达最大值时
								if (nSecond > sDate[sDate.length - 1]) {
									resetSecond();
									if (mi == mDate.length - 1) {
										resetMin();
										if (hi == hDate.length - 1) {
											resetHour();
											if (Di == DDate.length - 1) {
												resetDay();
												if (Mi == MDate.length - 1) {
													resetMonth();
													continue goYear;
												}
												continue goMonth;
											}
											continue goDay;
										}
										continue goHour;
									}
									continue;
								}
								// 循环"秒"数组
								goSecond: for (let si = sIdx; si <= sDate.length - 1; si++) {
									let ss = sDate[si] < 10 ? '0' + sDate[si] : sDate[si];
									// 添加当前时间（时间合法性在日期循环时已经判断）
									if (MM !== '00' && DD !== '00') {
										resultArr.push(YY + '-' + MM + '-' + DD + ' ' + hh + ':' + mm + ':' + ss)
										nums++;
									}
									// like果article数满了就exit循环
									if (nums == 5) break goYear;
									// like果到达最大值时
									if (si == sDate.length - 1) {
										resetSecond();
										if (mi == mDate.length - 1) {
											resetMin();
											if (hi == hDate.length - 1) {
												resetHour();
												if (Di == DDate.length - 1) {
													resetDay();
													if (Mi == MDate.length - 1) {
														resetMonth();
														continue goYear;
													}
													continue goMonth;
												}
												continue goDay;
											}
											continue goHour;
										}
										continue goMin;
									}
								} //goSecond
							} //goMin
						}//goHour
					}//goDay
				}//goMonth
			}
			// 判断100Year内的结果article数
			if (resultArr.length == 0) {
				this.resultList = ['没有达到article件的结果！'];
			} else {
				this.resultList = resultArr;
				if (resultArr.length !== 5) {
					this.resultList.push('最近100Year内只有上面' + resultArr.length + 'article结果！')
				}
			}
			// 计算完成-show结果
			this.isShow = true;


		},
		// 用于计算某位数字在数组中的索引
		getIndex(arr, value) {
			if (value <= arr[0] || value > arr[arr.length - 1]) {
				return 0;
			} else {
				for (let i = 0; i < arr.length - 1; i++) {
					if (value > arr[i] && value <= arr[i + 1]) {
						return i + 1;
					}
				}
			}
		},
		// 获取"Year"数组
		getYearArr(rule, year) {
			this.dateArr[5] = this.getOrderArr(year, year + 100);
			if (rule !== undefined) {
				if (rule.indexOf('-') >= 0) {
					this.dateArr[5] = this.getCycleArr(rule, year + 100, false)
				} else if (rule.indexOf('/') >= 0) {
					this.dateArr[5] = this.getAverageArr(rule, year + 100)
				} else if (rule !== '*') {
					this.dateArr[5] = this.getAssignArr(rule)
				}
			}
		},
		// 获取"Months"数组
		getMonthArr(rule) {
			this.dateArr[4] = this.getOrderArr(1, 12);
			if (rule.indexOf('-') >= 0) {
				this.dateArr[4] = this.getCycleArr(rule, 12, false)
			} else if (rule.indexOf('/') >= 0) {
				this.dateArr[4] = this.getAverageArr(rule, 12)
			} else if (rule !== '*') {
				this.dateArr[4] = this.getAssignArr(rule)
			}
		},
		// 获取"日"数组-主要is日期规则
		getWeekArr(rule) {
			// 只有当日期规则的两个值均is“”时则表达日期Yes有选项的
			if (this.dayRule == '' && this.dayRuleSup == '') {
				if (rule.indexOf('-') >= 0) {
					this.dayRule = 'weekDay';
					this.dayRuleSup = this.getCycleArr(rule, 7, false)
				} else if (rule.indexOf('#') >= 0) {
					this.dayRule = 'assWeek';
					let matchRule = rule.match(/[0-9]{1}/g);
					this.dayRuleSup = [Number(matchRule[1]), Number(matchRule[0])];
					this.dateArr[3] = [1];
					if (this.dayRuleSup[1] == 7) {
						this.dayRuleSup[1] = 0;
					}
				} else if (rule.indexOf('L') >= 0) {
					this.dayRule = 'lastWeek';
					this.dayRuleSup = Number(rule.match(/[0-9]{1,2}/g)[0]);
					this.dateArr[3] = [31];
					if (this.dayRuleSup == 7) {
						this.dayRuleSup = 0;
					}
				} else if (rule !== '*' && rule !== '?') {
					this.dayRule = 'weekDay';
					this.dayRuleSup = this.getAssignArr(rule)
				}
			}
		},
		// 获取"日"数组-少量is日期规则
		getDayArr(rule) {
			this.dateArr[3] = this.getOrderArr(1, 31);
			this.dayRule = '';
			this.dayRuleSup = '';
			if (rule.indexOf('-') >= 0) {
				this.dateArr[3] = this.getCycleArr(rule, 31, false)
				this.dayRuleSup = 'null';
			} else if (rule.indexOf('/') >= 0) {
				this.dateArr[3] = this.getAverageArr(rule, 31)
				this.dayRuleSup = 'null';
			} else if (rule.indexOf('W') >= 0) {
				this.dayRule = 'workDay';
				this.dayRuleSup = Number(rule.match(/[0-9]{1,2}/g)[0]);
				this.dateArr[3] = [this.dayRuleSup];
			} else if (rule.indexOf('L') >= 0) {
				this.dayRule = 'lastDay';
				this.dayRuleSup = 'null';
				this.dateArr[3] = [31];
			} else if (rule !== '*' && rule !== '?') {
				this.dateArr[3] = this.getAssignArr(rule)
				this.dayRuleSup = 'null';
			} else if (rule == '*') {
				this.dayRuleSup = 'null';
			}
		},
		// 获取"时"数组
		getHourArr(rule) {
			this.dateArr[2] = this.getOrderArr(0, 23);
			if (rule.indexOf('-') >= 0) {
				this.dateArr[2] = this.getCycleArr(rule, 24, true)
			} else if (rule.indexOf('/') >= 0) {
				this.dateArr[2] = this.getAverageArr(rule, 23)
			} else if (rule !== '*') {
				this.dateArr[2] = this.getAssignArr(rule)
			}
		},
		// 获取"分"数组
		getMinArr(rule) {
			this.dateArr[1] = this.getOrderArr(0, 59);
			if (rule.indexOf('-') >= 0) {
				this.dateArr[1] = this.getCycleArr(rule, 60, true)
			} else if (rule.indexOf('/') >= 0) {
				this.dateArr[1] = this.getAverageArr(rule, 59)
			} else if (rule !== '*') {
				this.dateArr[1] = this.getAssignArr(rule)
			}
		},
		// 获取"秒"数组
		getSecondArr(rule) {
			this.dateArr[0] = this.getOrderArr(0, 59);
			if (rule.indexOf('-') >= 0) {
				this.dateArr[0] = this.getCycleArr(rule, 60, true)
			} else if (rule.indexOf('/') >= 0) {
				this.dateArr[0] = this.getAverageArr(rule, 59)
			} else if (rule !== '*') {
				this.dateArr[0] = this.getAssignArr(rule)
			}
		},
		// 根据传进来的min-max返回一个order的数组
		getOrderArr(min, max) {
			let arr = [];
			for (let i = min; i <= max; i++) {
				arr.push(i);
			}
			return arr;
		},
		// 根据规则中指定的零散值返回一个数组
		getAssignArr(rule) {
			let arr = [];
			let assiginArr = rule.split(',');
			for (let i = 0; i < assiginArr.length; i++) {
				arr[i] = Number(assiginArr[i])
			}
			arr.sort(this.compare)
			return arr;
		},
		// 根据一定算术规则计算返回一个数组
		getAverageArr(rule, limit) {
			let arr = [];
			let agArr = rule.split('/');
			let min = Number(agArr[0]);
			let step = Number(agArr[1]);
			while (min <= limit) {
				arr.push(min);
				min += step;
			}
			return arr;
		},
		// 根据规则返回一个具有周期性的数组
		getCycleArr(rule, limit, status) {
			// status--表示YesNo从0开始（则从1开始）
			let arr = [];
			let cycleArr = rule.split('-');
			let min = Number(cycleArr[0]);
			let max = Number(cycleArr[1]);
			if (min > max) {
				max += limit;
			}
			for (let i = min; i <= max; i++) {
				let add = 0;
				if (status == false && i % limit == 0) {
					add = limit;
				}
				arr.push(Math.round(i % limit + add))
			}
			arr.sort(this.compare)
			return arr;
		},
		// 比较数字大小（用于Array.sort）
		compare(value1, value2) {
			if (value2 - value1 > 0) {
				return -1;
			} else {
				return 1;
			}
		},
		// 格式化日期格式like：2017-9-19 18:04:33
		formatDate(value, type) {
			// 计算日期相关值
			let time = typeof value == 'number' ? new Date(value) : value;
			let Y = time.getFullYear();
			let M = time.getMonth() + 1;
			let D = time.getDate();
			let h = time.getHours();
			let m = time.getMinutes();
			let s = time.getSeconds();
			let week = time.getDay();
			// like果传递了type的话
			if (type == undefined) {
				return Y + '-' + (M < 10 ? '0' + M : M) + '-' + (D < 10 ? '0' + D : D) + ' ' + (h < 10 ? '0' + h : h) + ':' + (m < 10 ? '0' + m : m) + ':' + (s < 10 ? '0' + s : s);
			} else if (type == 'week') {
				// 在quartz中 1is星期日
				return week + 1;
			}
		},
		// 检查日期YesNo存在
		checkDate(value) {
			let time = new Date(value);
			let format = this.formatDate(time)
			return value === format;
		}
	},
	watch: {
		'ex': 'expressionChange'
	},
	props: ['ex'],
	mounted: function () {
		// 初始化 获取一次结果
		this.expressionChange();
	}
}

</script>

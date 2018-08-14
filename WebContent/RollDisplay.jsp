<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <style type="text/css">
		#frame {/*----------图片轮播相框容器----------*/
			position: absolute; /*--绝对定位，方便子元素的定位*/
			width: 1000px;
			height: 320px;
			overflow: hidden;/*--相框作用，只显示一个图片---*/
			border-radius:5px;
		}

		#photos img {
			float: left;
			width:1000px;
			height:320px;
		}
		#photos {/*---设置总的图片宽度--通过位移来达到轮播效果----*/
			position: absolute;z-index:9px;
			width: calc(1000px * 4);/*---修改图片数量的话需要修改下面的动画参数*/
		}
		.play{
			animation: ma 20s ease-out infinite alternate;/**/
		}
		@keyframes ma {/*---每图片切换有两个阶段：位移切换和静置。中间的效果可以任意定制----*/
			0%,25% {		margin-left: 0px;		}
			25%,50% {		margin-left: -1000px;	}
			50%,75% {		margin-left: -2000px;	}
			75%,100% {		margin-left: -3000px;	}
			
		}
		.num{
			position:absolute;z-index:10;
			display:inline-block;
			right:10px;top:290px;
			border-radius:100%;
			background:#fff;
			width:25px;height:25px;
			line-height:25px;
			cursor:pointer;
			color:#fff;
			text-align:center;
			opacity:0.8;
		}
		.num:hover{background:#00f;}
		.num:hover,#photos:hover{animation-play-state:paused;}
		.num:nth-child(2){margin-right:30px}
		.num:nth-child(3){margin-right:60px}
		.num:nth-child(4){margin-right:90px}
	
		#a1:hover ~ #photos{animation: ma1 .5s ease-out forwards;}
		#a2:hover ~ #photos{animation: ma2 .5s ease-out forwards;}
		#a3:hover ~ #photos{animation: ma3 .5s ease-out forwards;}
		#a4:hover ~ #photos{animation: ma4 .5s ease-out forwards;}
	
		@keyframes ma1 {0%{margin-left:-3000px;}100%{margin-left:-0px;}	}
		@keyframes ma2 {0%{margin-left:-3000px;}100%{margin-left:-1000px;}	}
		@keyframes ma3 {100%{margin-left:-2000px;}	}
		@keyframes ma4 {100%{margin-left:-3000px;}	}
		
  </style>
  <div id="frame">
		<a id="a1" class="num">4</a>
		<a id="a2" class="num">3</a>
		<a id="a3" class="num">2</a>
		<a id="a4" class="num">1</a>
	
		<div id="photos" class="play">
			  <img src="images/1.jpg" >
			  <img src="images/2.jpg" >
			  <img src="images/4.jpg" >
			  <img src="images/5.jpg" >
			  <ul id="dis">
			  </ul>
		</div>
</div>
  
  
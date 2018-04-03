package com.it.onex.onex.bean;

import java.util.List;

/**
 * Created by OnexZgj on 2018/4/3:10:03.
 * des:去掉最外层的一套嵌套bean
 */

public class Article {

    /**
     * curPage : 1
     * datas : [{"apkLink":"","author":"zas023","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"程序设计\u2014\u2014记账本之Android（采用MVP模式开发，后台使用ssm框架） https://github.com/zas023/ssmBillBook\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/3f62ba6f-c3cd-4a96-a02c-538e1e38726a.png","fresh":true,"id":2734,"link":"http://www.wanandroid.com/blog/show/2101","niceDate":"14小时前","origin":"","projectLink":"https://github.com/zas023/CocoBill","publishTime":1522668463000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"Android 开源记账本 CocoBill","type":0,"visible":1,"zan":0},{"apkLink":"","author":" 黄宁源","chapterId":100,"chapterName":"RecyclerView","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":2733,"link":"https://mp.weixin.qq.com/s/-CzDkEur-iIX0lPMsIS0aA","niceDate":"16小时前","origin":"","projectLink":"","publishTime":1522657850000,"superChapterId":193,"superChapterName":"5.+高新技术","tags":[],"title":"Android ListView 与 RecyclerView 对比浅析--缓存机制","type":0,"visible":1,"zan":0},{"apkLink":"","author":"Jhuster","chapterId":97,"chapterName":"音视频","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":1467,"link":"http://ticktick.blog.51cto.com/823160/1956269","niceDate":"19小时前","origin":"","projectLink":"","publishTime":1522650305000,"superChapterId":97,"superChapterName":"多媒体技术","tags":[],"title":"Android 音视频开发入门指南","type":0,"visible":1,"zan":0},{"apkLink":"","author":"尘封的落叶 ","chapterId":149,"chapterName":"so文件相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":2732,"link":"https://www.jianshu.com/p/dbee203db243","niceDate":"19小时前","origin":"","projectLink":"","publishTime":1522647989000,"superChapterId":182,"superChapterName":"JNI","tags":[],"title":"NDK开发\u2014仿QQ变声器","type":0,"visible":1,"zan":0},{"apkLink":"","author":"r17171709","chapterId":341,"chapterName":"键盘","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":2731,"link":"https://www.jianshu.com/p/3db82632bd68","niceDate":"20小时前","origin":"","projectLink":"","publishTime":1522646867000,"superChapterId":30,"superChapterName":"用户交互","tags":[],"title":"一起来做一个简单的键盘吧","type":0,"visible":1,"zan":0},{"apkLink":"","author":"Jensen_czx","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2729,"link":"https://www.jianshu.com/p/02d32ef00337","niceDate":"2018-03-29","origin":"","projectLink":"","publishTime":1522321528000,"superChapterId":196,"superChapterName":"热门专题","tags":[],"title":"Android 资源加载机制剖析","type":0,"visible":1,"zan":0},{"apkLink":"","author":"猛猛的小盆友","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2728,"link":"https://www.jianshu.com/p/d804c78bb8e1","niceDate":"2018-03-29","origin":"","projectLink":"","publishTime":1522321505000,"superChapterId":196,"superChapterName":"热门专题","tags":[],"title":"内存泄漏与排查流程\u2014\u2014安卓性能优化","type":0,"visible":1,"zan":0},{"apkLink":"","author":"sunbinqiang","chapterId":222,"chapterName":"持续集成","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2727,"link":"https://www.jianshu.com/p/6729dc17586b","niceDate":"2018-03-29","origin":"","projectLink":"","publishTime":1522321481000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"网络加载图片对比（Fresco/Glide）","type":0,"visible":1,"zan":0},{"apkLink":"","author":"gexinzhao","chapterId":222,"chapterName":"持续集成","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2726,"link":"https://www.jianshu.com/p/74dd11121fc7","niceDate":"2018-03-29","origin":"","projectLink":"","publishTime":1522321461000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"Android 使用Jenkins(最新版)持续集成打包发包(MAC)","type":0,"visible":1,"zan":0},{"apkLink":"","author":"sunjenry","chapterId":334,"chapterName":"Architecture Components","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2719,"link":"http://www.jianshu.com/p/42eb71ec4a19","niceDate":"2018-03-28","origin":"","projectLink":"","publishTime":1522231026000,"superChapterId":193,"superChapterName":"5.+高新技术","tags":[],"title":"理解Android Architecture Components系列（一）","type":0,"visible":1,"zan":0},{"apkLink":"","author":"sunjenry","chapterId":334,"chapterName":"Architecture Components","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2720,"link":"http://www.jianshu.com/p/84a3442955ae","niceDate":"2018-03-28","origin":"","projectLink":"","publishTime":1522231024000,"superChapterId":193,"superChapterName":"5.+高新技术","tags":[],"title":"理解Android Architecture Components系列（二）","type":0,"visible":1,"zan":0},{"apkLink":"","author":"sunjenry","chapterId":334,"chapterName":"Architecture Components","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2721,"link":"http://www.jianshu.com/p/9f811caf200d","niceDate":"2018-03-28","origin":"","projectLink":"","publishTime":1522231023000,"superChapterId":193,"superChapterName":"5.+高新技术","tags":[],"title":"理解Android Architecture Components系列之Lifecycle（三）","type":0,"visible":1,"zan":0},{"apkLink":"","author":"sunjenry","chapterId":334,"chapterName":"Architecture Components","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2722,"link":"http://www.jianshu.com/p/e18055687b75","niceDate":"2018-03-28","origin":"","projectLink":"","publishTime":1522231021000,"superChapterId":193,"superChapterName":"5.+高新技术","tags":[],"title":"理解Android Architecture Components系列之LiveData（四）","type":0,"visible":1,"zan":0},{"apkLink":"","author":"sunjenry","chapterId":334,"chapterName":"Architecture Components","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2723,"link":"http://www.jianshu.com/p/77909ccb8bf0","niceDate":"2018-03-28","origin":"","projectLink":"","publishTime":1522231019000,"superChapterId":193,"superChapterName":"5.+高新技术","tags":[],"title":"理解Android Architecture Components系列之ViewModel（五）","type":0,"visible":1,"zan":0},{"apkLink":"","author":"sunjenry","chapterId":334,"chapterName":"Architecture Components","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2724,"link":"http://www.jianshu.com/p/b629df43c04e","niceDate":"2018-03-28","origin":"","projectLink":"","publishTime":1522231018000,"superChapterId":193,"superChapterName":"5.+高新技术","tags":[],"title":"理解Android Architecture Components系列之Room（六）","type":0,"visible":1,"zan":0},{"apkLink":"","author":"sunjenry","chapterId":334,"chapterName":"Architecture Components","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2725,"link":"http://www.jianshu.com/p/a05943b8a9c1","niceDate":"2018-03-28","origin":"","projectLink":"","publishTime":1522231012000,"superChapterId":193,"superChapterName":"5.+高新技术","tags":[],"title":"理解Android Architecture Components系列之Paging Library（七）","type":0,"visible":1,"zan":0},{"apkLink":"","author":"骑小猪看流星","chapterId":67,"chapterName":"网络基础","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2707,"link":"https://www.jianshu.com/p/bd1be47a16c1","niceDate":"2018-03-27","origin":"","projectLink":"","publishTime":1522158935000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"Cookie、Session、Token那点事儿","type":0,"visible":1,"zan":0},{"apkLink":"","author":"gzw19931217","chapterId":339,"chapterName":"K线图","collect":false,"courseId":13,"desc":"Android专业版K线图、分时图\r\n ","envelopePic":"http://www.wanandroid.com/blogimgs/b39bd2cd-2f7d-4365-b7a2-b188a3d8c43a.png","fresh":false,"id":2706,"link":"http://www.wanandroid.com/blog/show/2099","niceDate":"2018-03-27","origin":"","projectLink":"https://github.com/gzw19931217/android-kline","publishTime":1522150739000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=339"}],"title":"Android专业版K线图、分时图 android-kline","type":0,"visible":1,"zan":0},{"apkLink":"","author":"GinkWang","chapterId":228,"chapterName":"辅助 or 工具类","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2704,"link":"https://www.jianshu.com/p/68746e1476a7","niceDate":"2018-03-27","origin":"","projectLink":"","publishTime":1522150437000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"Android APK 省心安装 \u2014\u2014 眼睁睁地看着它完成一切","type":0,"visible":1,"zan":0},{"apkLink":"","author":"JYcoder","chapterId":228,"chapterName":"辅助 or 工具类","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2703,"link":"https://www.jianshu.com/p/3d9ee98a9570","niceDate":"2018-03-27","origin":"","projectLink":"","publishTime":1522150419000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"关于基类的那些事","type":0,"visible":1,"zan":0}]
     * offset : 0
     * over : false
     * pageCount : 60
     * size : 20
     * total : 1183
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * apkLink :
         * author : zas023
         * chapterId : 294
         * chapterName : 完整项目
         * collect : false
         * courseId : 13
         * desc : 程序设计——记账本之Android（采用MVP模式开发，后台使用ssm框架） https://github.com/zas023/ssmBillBook
         * <p>
         * envelopePic : http://www.wanandroid.com/blogimgs/3f62ba6f-c3cd-4a96-a02c-538e1e38726a.png
         * fresh : true
         * id : 2734
         * link : http://www.wanandroid.com/blog/show/2101
         * niceDate : 14小时前
         * origin :
         * projectLink : https://github.com/zas023/CocoBill
         * publishTime : 1522668463000
         * superChapterId : 294
         * superChapterName : 开源项目主Tab
         * tags : [{"name":"项目","url":"/project/list/1?cid=294"}]
         * title : Android 开源记账本 CocoBill
         * type : 0
         * visible : 1
         * zan : 0
         */

        private String apkLink;
        private String author;
        private int chapterId;
        private String chapterName;
        private boolean collect;
        private int courseId;
        private String desc;
        private String envelopePic;
        private boolean fresh;
        private int id;
        private String link;
        private String niceDate;
        private String origin;
        private String projectLink;
        private long publishTime;
        private int superChapterId;
        private String superChapterName;
        private String title;
        private int type;
        private int visible;
        private int zan;
        private List<TagsBean> tags;

        public String getApkLink() {
            return apkLink;
        }

        public void setApkLink(String apkLink) {
            this.apkLink = apkLink;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public boolean isFresh() {
            return fresh;
        }

        public void setFresh(boolean fresh) {
            this.fresh = fresh;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getProjectLink() {
            return projectLink;
        }

        public void setProjectLink(String projectLink) {
            this.projectLink = projectLink;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getSuperChapterId() {
            return superChapterId;
        }

        public void setSuperChapterId(int superChapterId) {
            this.superChapterId = superChapterId;
        }

        public String getSuperChapterName() {
            return superChapterName;
        }

        public void setSuperChapterName(String superChapterName) {
            this.superChapterName = superChapterName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class TagsBean {
            /**
             * name : 项目
             * url : /project/list/1?cid=294
             */

            private String name;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

}

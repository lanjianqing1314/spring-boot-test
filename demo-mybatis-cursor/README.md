# MyBatis 流式查询

MyBatis提供org.apache.ibatis.cursor.Cursor的接口用于流式查询，该接口继承了java.io.Closeable 和 java.lang.Iterable 接口，由此可知：
Cursor 是可关闭的；
Cursor 是可遍历的。

除此之外，Cursor 还提供了三个方法：
isOpen()：用于在取数据之前判断 Cursor 对象是否是打开状态。只有当打开时 Cursor 才能取数据；
isConsumed()：用于判断查询结果是否全部取完。
getCurrentIndex()：返回已经获取了多少条数据
因为 Cursor 实现了迭代器接口，因此在实际使用当中，从 Cursor 取数据非常简单

# 延伸阅读

[mp.weixin.qq.com/s/cn5ATEwH-bllWZQaNV0nug](https://mp.weixin.qq.com/s/cn5ATEwH-bllWZQaNV0nug)
## 个人笔记
### spring 生命周期
```flow
st=>start: Bean实例化
op_auto=>operation: Bean属性注入
op_baware=>operation: 调用BeanNameAware的setBeanName()方法
op_faware=>operation: 调用BeanFactoryAware的setBeanFactory()方法
op_caware=>operation: 调用ApplicationContexAware的setApplicationContext()方法
op_processor=>operation: 调用BeanPostProcessor的预初始化方法(Bean前置处理器)
op_initb=>operation: 调用InitializingBean的afterPropertiesSet()方法
op_init=>operation: 调用自定义初始化方法
op_aprocessor=>operation: 调用BeanPostProcessor的初始化方法（Bean后置处理器）
cond=>condition: bean可以使用了
op_de=>operation: 调用DisposableBean的destroy方法
op_des=>operation: 调用自定义的destroy方法
e=>end: 结束
st->op_auto->op_baware->op_faware->op_caware->op_processor->op_initb->op_init->op_aprocessor->cond
cond(容器关闭)->op_de->op_des->e
```

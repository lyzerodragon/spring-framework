/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.lang.Nullable;

/**
 * 为应用程序提供配置的中央接口。在应用程序运行时这是只读的，但如果实现支持它可以重新加载。
 *
 * <p>ApplicationContext 提供：
 * <ul>
 * <li>用于访问应用程序组件的 Bean 工厂方法。 继承自 {@link org.springframework.beans.factory.ListableBeanFactory}.
 * <li>以通用方式加载文件资源的能力。继承自 {@link org.springframework.core.io.ResourceLoader} 接口.
 * <li>向注册的侦听器发布事件的能力。继承自 {@link ApplicationEventPublisher} 接口.
 * <li>解析消息的能力，支持国际化。继承自 {@link MessageSource} 接口.
 * <li>从父上下文继承。后代上下文中的定义将始终优先。
 * 这意味着，例如，整个 Web 应用程序可以使用单个父上下文，而每个 servlet 都有自己的子上下文，独立于任何其他 servlet 的子上下文。
 * </ul>
 *
 * <p>除了标准 {@link org.springframework.beans.factory.BeanFactory}
 * 生命周期功能，ApplicationContext 实现检测和调用
 * {@link ApplicationContextAware} beans 以及 {@link ResourceLoaderAware},
 * {@link ApplicationEventPublisherAware} 和 {@link MessageSourceAware} beans.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see ConfigurableApplicationContext
 * @see org.springframework.beans.factory.BeanFactory
 * @see org.springframework.core.io.ResourceLoader
 */
public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory,
		MessageSource, ApplicationEventPublisher, ResourcePatternResolver {

	/**
	 * 返回此应用程序上下文的唯一 ID。
	 * @return 上下文的唯一标识，或 {@code null} 如果没有。
	 */
	@Nullable
	String getId();

	/**
	 * 返回此上下文所属的已部署应用程序的名称。
	 * @return 已部署应用程序的名称，或默认为空字符串。
	 */
	String getApplicationName();

	/**
	 * 返回此上下文的友好名称。
	 * 此上下文的显示名称
	 * Return a friendly name for this context.
	 * @return a display name for this context (never {@code null})
	 */
	String getDisplayName();

	/**
	 * 返回首次加载此上下文时的时间戳。
	 * 首次加载此上下文时的时间戳（毫秒）
	 * Return the timestamp when this context was first loaded.
	 * @return the timestamp (ms) when this context was first loaded
	 */
	long getStartupDate();

	/**
	 * 返回父上下文，如果没有父上下文并且这是上下文层次结构的根，则返回 {@code null}。
	 * 父上下文，如果没有父上下文，则为 {@code null}
	 * Return the parent context, or {@code null} if there is no parent
	 * and this is the root of the context hierarchy.
	 * @return the parent context, or {@code null} if there is no parent
	 */
	@Nullable
	ApplicationContext getParent();

	/**
	 * 自动装配Bean
	 * Expose AutowireCapableBeanFactory functionality for this context.
	 * <p>This is not typically used by application code, except for the purpose of
	 * initializing bean instances that live outside the application context,
	 * applying the Spring bean lifecycle (fully or partly) to them.
	 * <p>Alternatively, the internal BeanFactory exposed by the
	 * {@link ConfigurableApplicationContext} interface offers access to the
	 * {@link AutowireCapableBeanFactory} interface too. The present method mainly
	 * serves as a convenient, specific facility on the ApplicationContext interface.
	 * <p><b>NOTE: As of 4.2, this method will consistently throw IllegalStateException
	 * after the application context has been closed.</b> In current Spring Framework
	 * versions, only refreshable application contexts behave that way; as of 4.2,
	 * all application context implementations will be required to comply.
	 * @return the AutowireCapableBeanFactory for this context
	 * @throws IllegalStateException if the context does not support the
	 * {@link AutowireCapableBeanFactory} interface, or does not hold an
	 * autowire-capable bean factory yet (e.g. if {@code refresh()} has
	 * never been called), or if the context has been closed already
	 * @see ConfigurableApplicationContext#refresh()
	 * @see ConfigurableApplicationContext#getBeanFactory()
	 */
	AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException;

}

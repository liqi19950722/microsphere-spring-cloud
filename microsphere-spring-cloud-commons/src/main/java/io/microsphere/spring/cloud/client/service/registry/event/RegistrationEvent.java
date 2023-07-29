/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.microsphere.spring.cloud.client.service.registry.event;

import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;
import org.springframework.context.ApplicationEvent;

/**
 * The Spring event for {@link ServiceRegistry}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see RegistrationPreRegisteredEvent
 * @see RegistrationRegisteredEvent
 * @see RegistrationPreDeregisteredEvent
 * @see RegistrationDeregisteredEvent
 * @see ServiceRegistry
 * @since 1.0.0
 */
public abstract class RegistrationEvent extends ApplicationEvent {

    private final ServiceRegistry<Registration> registry;

    public RegistrationEvent(ServiceRegistry<Registration> registry, Registration source) {
        super(source);
        this.registry = registry;
    }

    @Override
    public Registration getSource() {
        return (Registration) super.getSource();
    }

    public ServiceRegistry<Registration> getRegistry() {
        return registry;
    }

    public final boolean isPreRegistered() {
        return !isRegistered();
    }

    public abstract boolean isRegistered();

    public final boolean isPreDeregistered() {
        return !isDeregistered();
    }

    public abstract boolean isDeregistered();

}
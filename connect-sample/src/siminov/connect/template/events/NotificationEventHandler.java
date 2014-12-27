/** 
 * [SIMINOV FRAMEWORK]
 * Copyright [2015] [Siminov Software Solution LLP|support@siminov.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package siminov.connect.template.events;

import siminov.connect.events.INotificationEvents;
import siminov.connect.exception.NotificationException;
import siminov.connect.notification.design.IMessage;
import siminov.connect.notification.design.IRegistration;
import siminov.connect.service.design.IService;
import siminov.connect.template.services.RegisterDevice;
import siminov.connect.template.services.UnregisterDevice;

public class NotificationEventHandler implements INotificationEvents {

	public void onRegistration(IRegistration registration) {
		
		IService service = new RegisterDevice();
		service.addResource(RegisterDevice.REGISTRATION_ID, registration.getRegistrationId());
		
		service.invoke();
	}

	public void onUnregistration(IRegistration registration) {

		IService service = new UnregisterDevice();
		service.invoke();
	}

	public void onNotification(IMessage message) {
		
	}

	public void onError(NotificationException notificationException) {
		
	}
}

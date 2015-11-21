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

package siminov.core.sample.model;

import siminov.core.database.Database;

public class LiquorShopMapping extends Database {

	//Table Name
	transient public static final String TABLE_NAME = "LIQUOR_SHOP_MAPPING";
	
	//Variable Names
	private Liquor liquor = null;
	private Shop shop = null;
	
	
	//Method Names
	
	public Liquor getLiquor() {
		return this.liquor;
	}
	
	public void setLiquor(Liquor liquor) {
		this.liquor = liquor;
	}
	
	public Shop getShop() {
		return this.shop;
	}
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}
}

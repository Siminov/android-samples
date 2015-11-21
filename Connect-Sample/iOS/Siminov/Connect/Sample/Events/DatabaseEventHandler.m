///
/// [SIMINOV FRAMEWORK]
/// Copyright [2015] [Siminov Software Solution LLP|support@siminov.com]
///
/// Licensed under the Apache License, Version 2.0 (the "License");
/// you may not use this file except in compliance with the License.
/// You may obtain a copy of the License at
///
///     http://www.apache.org/licenses/LICENSE-2.0
///
/// Unless required by applicable law or agreed to in writing, software
/// distributed under the License is distributed on an "AS IS" BASIS,
/// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
/// See the License for the specific language governing permissions and
/// limitations under the License.
///

#import "DatabaseEventHandler.h"

@implementation DatabaseEventHandler

- (void)onDatabaseCreated:(SICDatabaseDescriptor * const)databaseDescriptor {
}

- (void)onDatabaseDropped:(SICDatabaseDescriptor * const)databaseDescriptor {
}

- (void)onTableCreated:(SICDatabaseDescriptor * const)databaseDescriptor entityDescriptor:(SICEntityDescriptor * const)entityDescriptor {
}

- (void)onTableDropped:(SICDatabaseDescriptor * const)databaseDescriptor entityDescriptor:(SICEntityDescriptor * const)entityDescriptor {
}

- (void)onIndexCreated:(SICDatabaseDescriptor * const)databaseDescriptor entityDescriptor:(SICEntityDescriptor * const)entityDescriptor index:(SICIndex *) index {
}

- (void)onIndexDropped: (SICDatabaseDescriptor * const)databaseDescriptor entityDescriptor:(SICEntityDescriptor * const)entityDescriptor index:(SICIndex *)index {
}

@end

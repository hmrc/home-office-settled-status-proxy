/*
 * Copyright 2020 HM Revenue & Customs
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
 */

package uk.gov.hmrc.homeofficesettledstatusproxy.models

import play.api.libs.json.{Format, Json}

case class ValidationError(
  // name of the parameter with a problem
  name: String,
  // Code of the validation failure
  code: String
)

object ValidationError {
  implicit val formats: Format[ValidationError] = Json.format[ValidationError]
}

case class StatusCheckError(
  // Top level error code
  errCode: String,
  // Field level validation errors
  fields: Option[List[ValidationError]] = None
)

object StatusCheckError {
  implicit val formats: Format[StatusCheckError] = Json.format[StatusCheckError]
}

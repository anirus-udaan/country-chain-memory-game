/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.udaantech.chainmemorygame.handlers;

import static com.amazon.ask.request.Predicates.requestType;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.SessionEndedRequest;
import com.udaantech.chainmemorygame.data.CountryLink;
import com.udaantech.chainmemorygame.data.GameControl;
import java.util.Optional;

public class SessionEndedRequestHandler implements RequestHandler {

  @Override
  public boolean canHandle(HandlerInput input) {
    return input.matches(requestType(SessionEndedRequest.class));
  }

  @Override
  public Optional<Response> handle(HandlerInput input) {
    // any cleanup logic goes here
    CountryLink.getInstance().clear();
    GameControl.getInstance().clear();

    return input.getResponseBuilder().build();
  }
}

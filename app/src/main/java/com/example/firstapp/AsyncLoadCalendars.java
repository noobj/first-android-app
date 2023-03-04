package com.example.firstapp;

/*
 * Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Asynchronously load the calendars.
 *
 * @author Yaniv Inbar
 */
class AsyncLoadCalendars extends CalendarAsyncTask {

    AsyncLoadCalendars(MainActivity calendarSample) {
        super(calendarSample);
    }

    @Override
    protected void doInBackground() throws IOException {
//        DateTime now = new DateTime("2023-02-01T12:41:45.14Z");
//        Events events = client.events().list("primary")
//                .setTimeMin(now)
//                .setSingleEvents(true)
//                .execute();
//        System.out.println(events.getItems());

        Event event = new Event().setSummary("Jizz");
        DateTime startDateTime = new DateTime(new Date());
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime);
        event.setStart(start);

        DateTime endDateTime = new DateTime(new Date());
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime);
        event.setEnd(end);

        event.setColorId("11").setReminders(null);

        event = client.events().insert("primary", event).execute();
        System.out.println(event.getHtmlLink());
    }

    static void run(MainActivity calendarSample) {
        new AsyncLoadCalendars(calendarSample).execute();
    }
}

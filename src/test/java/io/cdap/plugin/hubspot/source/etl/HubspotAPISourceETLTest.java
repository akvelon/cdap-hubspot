/*
 * Copyright © 2020 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.cdap.plugin.hubspot.source.etl;

import io.cdap.cdap.api.data.format.StructuredRecord;
import io.cdap.plugin.hubspot.common.SourceHubspotConfig;
import io.cdap.plugin.hubspot.common.TestingHelper;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import java.util.List;

public abstract class HubspotAPISourceETLTest extends BaseHubspotETLTest {
  protected static String authToken;

  @Test
  public void testContactLists() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Contact Lists",
                                                                      authToken,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null);
    try {
      TestingHelper.createTestObject(sourceHubspotConfig, readResourceFile("testContactlist.json"));
      List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 1);
      TestingHelper.checkExist(sourceHubspotConfig, records, true);
    } finally {
      TestingHelper.checkAndDelete(sourceHubspotConfig, false);
    }
  }

  @Test
  public void testContacts() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Contacts",
                                                                      authToken,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null);
    try {
      TestingHelper.createTestObject(sourceHubspotConfig, readResourceFile("testContact.json"));
      List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 1);
      TestingHelper.checkExist(sourceHubspotConfig, records, true);
    } finally {
      TestingHelper.checkAndDelete(sourceHubspotConfig, false);
    }
  }

  @Test
  public void testEmailEvents() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Email Events",
                                                                      authToken,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null);
    List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 0);
  }

  @Test
  public void testEmailSubscription() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Email Subscription",
                                                                      authToken,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null);
    List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 0);
  }

  @Test
  public void testRecentCompanies() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Recent Companies",
                                                                      authToken,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null);
    List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 0);
  }

  @Test
  public void testCompanies() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Companies",
                                                                      authToken,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null);
    try {
      TestingHelper.createTestObject(sourceHubspotConfig, readResourceFile("testCompany.json"));
      List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 1);
      TestingHelper.checkExist(sourceHubspotConfig, records, true);
    } finally {
      TestingHelper.checkAndDelete(sourceHubspotConfig, false);
    }
  }

  @Test
  public void testDeals() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Deals",
                                                                      authToken,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null);
    try {
      TestingHelper.createTestObject(sourceHubspotConfig, readResourceFile("testDeal.json"));
      List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 1);
      TestingHelper.checkExist(sourceHubspotConfig, records, true);
    } finally {
      TestingHelper.checkAndDelete(sourceHubspotConfig, false);
    }
  }

  @Test
  public void testDealPipelines() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Deal Pipelines",
                                                                      authToken,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null);
    try {
      // randomize to avoid soft delete ERROR
      TestingHelper.createTestObject(sourceHubspotConfig,
                                     "{\"pipelineId\":\"testName" +
                                       RandomStringUtils.random(20, false, true) +
                                       "\",\"label\":\"test Name\",\"displayOrder\":2," +
                                       "\"active\":true,\"stages\":[{\"stageId\":\"testStage" +
                                       RandomStringUtils.random(20, false, true) +
                                       "\",\"label\":\"test Stage\"," +
                                       "\"displayOrder\":1,\"metadata\":{\"probability\":0.5}}" +
                                       ",{\"stageId\":\"testStage2" +
                                       RandomStringUtils.random(20, false, true) +
                                       "\",\"label\":\"test Stage2\",\"displayOrder\":2," +
                                       "\"metadata\":{\"probability\":1.0}}]}");
      List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 1);
      TestingHelper.checkExist(sourceHubspotConfig, records, true);
    } finally {
      TestingHelper.checkAndDelete(sourceHubspotConfig, false);
    }
  }

  @Test
  public void testMarketingEmail() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Marketing Email",
                                                                      authToken,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null);
    try {
      TestingHelper.createTestObject(sourceHubspotConfig, readResourceFile("testMarketingEmail.json"));
      List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 1);
      TestingHelper.checkExist(sourceHubspotConfig, records, true);
    } finally {
      TestingHelper.checkAndDelete(sourceHubspotConfig, false);
    }
  }

  @Test
  public void testProducts() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Products",
        authToken,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null);
    try {
      TestingHelper.createTestObject(sourceHubspotConfig, readResourceFile("testProduct.json"));
      List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 1);
      TestingHelper.checkExist(sourceHubspotConfig, records, true);
    } finally {
      TestingHelper.checkAndDelete(sourceHubspotConfig, false);
    }
  }

  @Test
  public void testTickets() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Tickets",
        authToken,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null,
                                                                      null);
    try {
      TestingHelper.createTestObject(sourceHubspotConfig, readResourceFile("testTicket.json"));
      List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 1);
      TestingHelper.checkExist(sourceHubspotConfig, records, true);
    } finally {
      TestingHelper.checkAndDelete(sourceHubspotConfig, false);
    }
  }

  @Test
  public void testAnalyticsCategory() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Analytics",
        authToken,
                                                                      null,
                                                                      "20190101",
                                                                      "20191111",
                                                                      "Category",
                                                                      null,
                                                                      "totals",
                                                                      null,
                                                                      "total");
    List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 1);
  }

  @Test
  public void testAnalyticsContent() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Analytics",
        authToken,
                                                                      null,
                                                                      "20190101",
                                                                      "20191111",
                                                                      "Content",
                                                                      "standard-pages",
                                                                      null,
                                                                      null,
                                                                      "total");
    List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 0);
  }

  @Test
  public void testAnalyticsObject() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Analytics",
        authToken,
                                                                      null,
                                                                      "20190101",
                                                                      "20191111",
                                                                      "Object",
                                                                      null,
                                                                      null,
                                                                      "pages",
                                                                      "total");
    List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 0);
  }

  @Test
  public void testAnalyticsCategorySummarizeDaily() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Analytics",
        authToken,
                                                                      null,
                                                                      "20190101",
                                                                      "20191111",
                                                                      "Category",
                                                                      null,
                                                                      "totals",
                                                                      null,
                                                                      "summarize/daily");
    List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 1);
  }

  @Test
  public void testAnalyticsContentDaily() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Analytics",
        authToken,
                                                                      "client",
                                                                      "20190101",
                                                                      "20191111",
                                                                      "Content",
                                                                      "standard-pages",
                                                                      null,
                                                                      null,
                                                                      "daily");
    List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 1);
  }

  @Test
  public void testAnalyticsObjectMonthly() throws Exception {
    SourceHubspotConfig sourceHubspotConfig = new SourceHubspotConfig(testName.getMethodName(),
                                                                      null,
                                                                      "Analytics",
        authToken,
                                                                      "client",
                                                                      "20190101",
                                                                      "20191111",
                                                                      "Object",
                                                                      null,
                                                                      null,
                                                                      "pages",
                                                                      "monthly");

    List<StructuredRecord> records = getPipelineResults(sourceHubspotConfig, 1);
  }
}

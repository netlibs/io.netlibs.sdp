package com.jive.oss.sdp;

/*
 * #%L
 * sdp
 * %%
 * Copyright (C) 2015 Jive Communications, Inc
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.net.InetAddress;

import lombok.Value;

@Value
public class SdpAddress
{

  private static final String IN = "IN";

  private String networkType;
  private String addressType;
  private String address;

  public static SdpAddress from(InetAddress addr)
  {
    return new SdpAddress(IN, SdpUtils.getAddressType(addr), addr.getHostAddress());
  }

  public static SdpAddress v4(String host)
  {
    return new SdpAddress(IN, InetAddressType.IP4.toString(), host);
  }

  public static SdpAddress v6(String host)
  {
    return new SdpAddress(IN, InetAddressType.IP6.toString(), host);
  }

}

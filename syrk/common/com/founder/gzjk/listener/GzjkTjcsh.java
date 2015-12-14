package com.founder.gzjk.listener;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.founder.gzjk.romcache.BzdzRamCache;
import com.founder.gzjk.romcache.RamCache;
import com.founder.gzjk.romcache.SydwRamCache;
import com.founder.gzjk.romcache.SyfwRamCache;
import com.founder.gzjk.romcache.ZdryRamCache;
import com.founder.gzjk.tools.ZzjgMap;

@Component
public class GzjkTjcsh
  implements ApplicationListener<ContextRefreshedEvent>
{

  @Autowired
  private RamCache ramCache;

  @Autowired
  private BzdzRamCache bzdzRamCache;

  @Autowired
  private ZdryRamCache zdryRamCache;

  @Autowired
  private SydwRamCache sydwRamCache;

  @Autowired
  private SyfwRamCache syfwRamCache;

  @Autowired
  private ZzjgMap zzjgMap;

  public void onApplicationEvent(ContextRefreshedEvent event)
  {
    if (event.getApplicationContext().getParent() != null)
    {
      new Thread(new Runnable()
      {
        public void run() {
        /*  Map temp = GzjkTjcsh.this.zzjgMap.getZzjgMap();
          Map ramMap = new HashMap();
          ramMap.putAll(temp);
          System.out.println("实有人口开始" + Thread.currentThread().getName());
          GzjkTjcsh.this.ramCache.init2(ramMap);
          System.out.println("实有人口结束" + Thread.currentThread().getName());

          Map bzdzMap = new HashMap();
          bzdzMap.putAll(temp);
          System.out.println("标准地址开始" + Thread.currentThread().getName());
          GzjkTjcsh.this.bzdzRamCache.init2(bzdzMap);
          System.out.println("标准地址结束" + Thread.currentThread().getName());

          Map zdryMap = new HashMap();
          zdryMap.putAll(temp);
          System.out.println("重点人口开始" + Thread.currentThread().getName());
          GzjkTjcsh.this.zdryRamCache.init2(zdryMap);
          System.out.println("重点人口结束" + Thread.currentThread().getName());

          Map sydwMap = new HashMap();
          sydwMap.putAll(temp);
          System.out.println("实有单位开始" + Thread.currentThread().getName());
          GzjkTjcsh.this.sydwRamCache.init2(sydwMap);
          System.out.println("实有单位结束" + Thread.currentThread().getName());

          Map syfwMap = new HashMap();
          syfwMap.putAll(temp);
          System.out.println("实有房屋开始" + Thread.currentThread().getName());
          GzjkTjcsh.this.syfwRamCache.init2(syfwMap);
          System.out.println("实有房屋结束" + Thread.currentThread().getName());*/
        }
      }).start();
    }
  }
}
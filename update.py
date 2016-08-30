#encoding=utf-8
'''
Created on 2016年8月3日

@author: wang
'''
import tushare as ts
import pandas as pd
import MySQLdb as ms
import math
import datetime
import time
#更新mainlist
def updatemainlist():
    maindatalist=ts.get_stock_basics()
    maindata=pd.DataFrame(maindatalist)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
#     print data.columns
    values=[]
    for index,row in maindata.iterrows():
        values.append((index,row['name'],row['industry'],row['area'],row['pe'],row['outstanding'],row['totals'],row['totalAssets'],row['liquidAssets'],row['fixedAssets'],row['reserved'],row['reservedPerShare'],row['esp'],row['bvps'],row['pb'],row['timeToMarket']))
    cur.execute('delete from mainlist')
    cur.executemany('insert into mainlist (code,name,industry,area,pe,outstanding,totals,totalAssets,liquidAssets,fixedAssets,reserved,reservedPerShare,eps,bvps,pb,timeToMarket) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)',values)
    conn.commit()
    cur.close()
    conn.close()
    
#更新report
def updatereport():
    reportdatalist=ts.get_report_data(2014,4)
    reportdata=pd.DataFrame(reportdatalist)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    values=[]
    for index,row in reportdata.iterrows():
        if math.isnan(row['eps']):
            eps=0
        else:
            eps=row['eps']
         
        if math.isnan(row['eps_yoy']):
            eps_yoy=0
        else:
            eps_yoy=row['eps_yoy']
             
        if math.isnan(row['bvps']):
            bvps=0
        else:
            bvps=row['bvps']
             
        if math.isnan(row['epcf']):
            epcf=0
        else:
            epcf=row['epcf']
         
        if math.isnan(row['roe']):
            roe=0
        else:
            roe=row['roe'] 
               
        if math.isnan(row['net_profits']):
            net_profits=0
        else:
            net_profits=row['net_profits']  
             
        if math.isnan(row['profits_yoy']):
            profits_yoy=0
        else:
            profits_yoy=row['profits_yoy']  
        values.append((row['code'],row['name'],eps,eps_yoy,bvps,roe,epcf,net_profits,profits_yoy,'2015-'+row['report_date']))
    cur.executemany('insert into report20144 (code,name,eps,eps_yoy,bvps,roe,epcf,net_profis,profis_yoy,report_date) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)',values)
    conn.commit()
    cur.close()
    conn.close()
#更新operation
def updateoperation():
    reportdatalist=ts.get_operation_data(2014,1)
    reportdata=pd.DataFrame(reportdatalist)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    values=[]
    for index,row in reportdata.iterrows():
        if math.isnan(row['arturnover']):
            arturnover=0
        else:
            arturnover=row['arturnover']
            
        if math.isnan(row['arturndays']):
            arturndays=0
        else:
            arturndays=row['arturndays']
            
        if math.isnan(row['inventory_turnover']):
            inventory_turnover=0
        else:
            inventory_turnover=row['inventory_turnover']
        
        if math.isnan(row['inventory_days']):
            inventory_days=0
        else:
            inventory_days=row['inventory_days']
        
        if math.isnan(row['currentasset_turnover']):
            currentasset_turnover=0
        else:
            currentasset_turnover=row['currentasset_turnover']
        
        if math.isnan(row['currentasset_days']):
            currentasset_days=0
        else:
            currentasset_days=row['currentasset_days']
        values.append((row['code'],row['name'],arturnover,arturndays,inventory_turnover,inventory_days,currentasset_turnover,currentasset_days))
    cur.executemany('insert into operation20141 (code,name,arturnover,arturndays,inventory_turnover,inventory_days,currentasset_turnover,currentasset_days) values(%s,%s,%s,%s,%s,%s,%s,%s)',values)
    conn.commit()
    cur.close()
    conn.close()
#更新growth
def updategrowth():
    reportdatalist=ts.get_growth_data(2014,4)
    reportdata=pd.DataFrame(reportdatalist)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    values=[]
    for index,row in reportdata.iterrows():
        if math.isnan(row['mbrg']):
            mbrg=0
        else:
            mbrg=row['mbrg']
            
        if math.isnan(row['nprg']):
            nprg=0
        else:
            nprg=row['nprg']
            
        if math.isnan(row['nav']):
            nav=0
        else:
            nav=row['nav']
        
        if math.isnan(row['targ']):
            targ=0
        else:
            targ=row['targ']
        
        if math.isnan(row['epsg']):
            epsg=0
        else:
            epsg=row['epsg']
        
        if math.isnan(row['seg']):
            seg=0
        else:
            seg=row['seg']
        values.append((row['code'],row['name'],mbrg,nprg,nav,targ,epsg,seg))
    cur.executemany('insert into growth20144 (code,name,mbrg,nprg,nav,targ,epsg,seg) values(%s,%s,%s,%s,%s,%s,%s,%s)',values)
    conn.commit()
    cur.close()
    conn.close()
#更新debtpay
def updatedebtpay():
    debtpaydatalist=ts.get_debtpaying_data(2014,1)
    debtpaydata=pd.DataFrame(debtpaydatalist)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    values=[]
    for index,row in debtpaydata.iterrows():
        if row['currentratio']=='--':
            currentratio=0
        else:
            currentratio=row['currentratio']
        if row['quickratio']=='--':
            quickratio=0
        else:
            quickratio=row['quickratio']
        if row['cashratio']=='--':
            cashratio=0
        else:
            cashratio=row['cashratio']
        if row['icratio']=='--':
            icratio=0
        else:
            icratio=row['icratio']
        if row['sheqratio']=='--':
            sheqratio=0
        else:
            sheqratio=row['sheqratio']

        if row['adratio']=='--':
            adratio=0
        else:
            adratio=row['adratio']

        values.append((row['code'],row['name'],currentratio,quickratio,cashratio,icratio,sheqratio,adratio))
    cur.executemany('insert into debtpay20141 (code,name,currentratio,quickratio,cashratio,icratio,sheqratio,adratio) values(%s,%s,%s,%s,%s,%s,%s,%s)',values)
    conn.commit()
    cur.close()
    conn.close()
#更新cashflow
def updatecashflow():
    cashflowdatalist=ts.get_cashflow_data(2014,1)
    cashflowdata=pd.DataFrame(cashflowdatalist)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    values=[]
    for index,row in cashflowdata.iterrows():
        if math.isnan(row['cf_sales']):
            cf_sales=0
        else:
            cf_sales=row['cf_sales']
            
        if math.isnan(row['rateofreturn']):
            rateofreturn=0
        else:
            rateofreturn=row['rateofreturn']
            
        if math.isnan(row['cf_nm']):
            cf_nm=0
        else:
            cf_nm=row['cf_nm']
        
        if math.isnan(row['cf_liabilities']):
            cf_liabilities=0
        else:
            cf_liabilities=row['cf_liabilities']
        
        if math.isnan(row['cashflowratio']):
            cashflowratio=0
        else:
            cashflowratio=row['cashflowratio']
        
        values.append((row['code'],row['name'],cf_sales,rateofreturn,cf_nm,cf_liabilities,cashflowratio))
    cur.executemany('insert into cashflow20141 (code,name,cf_sales,rateofreturn,cf_nm,cf_liabilities,cashflowratio) values(%s,%s,%s,%s,%s,%s,%s)',values)
    conn.commit()
    cur.close()
    conn.close()
#更新small
def updatesmall():
    smalldatalist=ts.get_sme_classified()
    smalldata=pd.DataFrame(smalldatalist)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    values=[]
    for index,row in smalldata.iterrows():
        values.append((row['code'],row['name']))
    cur.executemany('insert into small (code,name) values(%s,%s)',values)
    conn.commit()
    cur.close()
    conn.close()
#更新gem
def updategem():
    gemdatalist=ts.get_gem_classified()
    gemdata=pd.DataFrame(gemdatalist)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    values=[]
    for index,row in gemdata.iterrows():
        values.append((row['code'],row['name']))
    cur.executemany('insert into gem (code,name) values(%s,%s)',values)
    conn.commit()
    cur.close()
    conn.close()
#更新risk
def updaterisk():
    riskdatalist=ts.get_st_classified()
    riskdata=pd.DataFrame(riskdatalist)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    values=[]
    for index,row in riskdata.iterrows():
        values.append((row['code'],row['name']))
    cur.executemany('insert into risk (code,name) values(%s,%s)',values)
    conn.commit()
    cur.close()
    conn.close()
#更新news
def updatenews():
    newsdatalist=ts.get_latest_news()
    newsdata=pd.DataFrame(newsdatalist)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    values=[]
    for index,row in newsdata.iterrows():
        values.append((row['classify'],row['title'],row['time'],row['url']))
    cur.execute('delete from news')
    cur.executemany('insert into news (classify,title,time,url) values(%s,%s,%s,%s)',values)
    conn.commit()
    cur.close()
    conn.close()
# 更新表marketlist 实时数据
def updateMarketlist():
    shdata=ts.get_realtime_quotes('sh')
    sh=pd.DataFrame(shdata)
    szdata=ts.get_realtime_quotes('sz')
    sz=pd.DataFrame(szdata)
    hs300data=ts.get_realtime_quotes('hs300')
    hs300=pd.DataFrame(hs300data)
    sz50data=ts.get_realtime_quotes('sz50')
    sz50=pd.DataFrame(sz50data)
    zxbdata=ts.get_realtime_quotes('zxb')
    zxb=pd.DataFrame(zxbdata)
    cybdata=ts.get_realtime_quotes('cyb')
    cyb=pd.DataFrame(cybdata)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    values=[]
    for index,row in sh.iterrows():
        values.append((row['code'],row['name'],row['open'],row['pre_close'],row['price'],row['high'],row['low'],row['volume'],row['amount'],row['date'],row['time']))
    for index,row in sz.iterrows():
        values.append((row['code'],row['name'],row['open'],row['pre_close'],row['price'],row['high'],row['low'],row['volume'],row['amount'],row['date'],row['time']))
    for index,row in hs300.iterrows():
        values.append((row['code'],row['name'],row['open'],row['pre_close'],row['price'],row['high'],row['low'],row['volume'],row['amount'],row['date'],row['time']))
    for index,row in sz50.iterrows():
        values.append((row['code'],row['name'],row['open'],row['pre_close'],row['price'],row['high'],row['low'],row['volume'],row['amount'],row['date'],row['time']))
    for index,row in zxb.iterrows():
        values.append((row['code'],row['name'],row['open'],row['pre_close'],row['price'],row['high'],row['low'],row['volume'],row['amount'],row['date'],row['time']))
    for index,row in cyb.iterrows():
        values.append((row['code'],row['name'],row['open'],row['pre_close'],row['price'],row['high'],row['low'],row['volume'],row['amount'],row['date'],row['time']))

    cur.execute('delete from marketlist')
    cur.executemany('insert into marketlist (code,name,open,pre_close,price,high,low,volume,amount,date,time) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)',values)
    conn.commit()
    cur.close()
    conn.close()
# 更新三个stocklist 实时数据
def updatestocklist():
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    cur.execute ("SELECT code FROM mainlist")  
    rows = cur.fetchall()  
    for row in rows: 
        code=row[0].encode('utf-8') 
        type_number=code[0]
        stocksonelist=ts.get_realtime_quotes(code)
        stocksone=pd.DataFrame(stocksonelist)
        values=[]
        for index,row in stocksone.iterrows():
            if row['b1_v']=='':
                b1_v=0
            else:
                b1_v=row['b1_v']
            if row['b2_v']=='':
                b2_v=0
            else:
                b2_v=row['b2_v']
            if row['b3_v']=='':
                b3_v=0
            else:
                b3_v=row['b3_v']
            if row['b4_v']=='':
                b4_v=0
            else:
                b4_v=row['b4_v']
            if row['b5_v']=='':
                b5_v=0
            else:
                b5_v=row['b5_v']
            if row['a1_v']=='':
                a1_v=0
            else:
                a1_v=row['a1_v']
            if row['a2_v']=='':
                a2_v=0
            else:
                a2_v=row['a2_v']
            if row['a3_v']=='':
                a3_v=0
            else:
                a3_v=row['a3_v']
            if row['a4_v']=='':
                a4_v=0
            else:
                a4_v=row['a4_v']
            if row['a5_v']=='':
                a5_v=0
            else:
                a5_v=row['a5_v']
            values.append((row['code'],row['name'],row['open'],row['pre_close'],row['price'],row['high'],row['low'],\
                           b1_v,row['b1_p'],b2_v,row['b2_p'],b3_v,row['b3_p'],b4_v,row['b4_p'],b5_v,row['b5_p'],\
                           a1_v,row['a1_p'],a2_v,row['a2_p'],a3_v,row['a3_p'],a4_v,row['a4_p'],a5_v,row['a5_p'],\
                           row['volume'],row['amount'],row['date'],row['time']))

        if type_number=='0':
            table_name='stocklist_sz'
        if type_number=='3':
            table_name='stocklist_cyb'
        if type_number=='6':
            table_name='stocklist_sh'
        cur.executemany('insert into '+table_name+' (code,name,open,pre_close,price,high,low,'\
                'b1_v,b1_p,b2_v,b2_p,b3_v,b3_p,b4_v,b4_p,b5_v,b5_p,'\
                'a1_v,a1_p,a2_v,a2_p,a3_v,a3_p,a4_v,a4_p,a5_v,a5_p,'\
                'volume,amount,date,time)'\
                'values(%s,%s,%s,%s,%s,%s,%s,'\
                '%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,'\
                '%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,'\
                '%s,%s,%s,%s)',values)
        conn.commit()  
    cur.close()
    conn.close() 
# 打开服务器时更新数据库中六个大盘历史数据
def updateMarketone():
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    market=['sh','sz','hs300','sz50','zxb','cyb']
    for x in market:
        selectstr='select max(date) from market_'+x
        cur.execute(selectstr)
        stus = cur.fetchall()
        s=''
        for stu in stus:
            s=stu[0]
        s = s + datetime.timedelta(1)
        now=time.strftime("%Y-%m-%d",time.localtime(time.time()))
        t=s.strftime('%Y-%m-%d')
        if t!=now:
            marketonelist=ts.get_hist_data(x,t,now)
            marketone=pd.DataFrame(marketonelist)
            values=[]
            for index,row in marketone.iterrows():
                values.append((index,row['open'],row['high'],row['close'],row['low'],row['volume'],row['price_change'],row['p_change'],\
                               row['ma5'],row['ma10'],row['ma20'],row['v_ma5'],row['v_ma10'],row['v_ma20']))
            insertstr='insert into market_'+x+' (date,open,high,close,low,volume,price_change,p_change,ma5,ma10,ma20,v_ma5,v_ma10,v_ma20) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'
            cur.executemany(insertstr,values)
        conn.commit()
    cur.close()
    conn.close()
#更新distribute
def updatedistribute():
    distributedatalist=ts.profit_data('2013')
    distributedata=pd.DataFrame(distributedatalist)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    values=[]
    for index,row in distributedata.iterrows():
        values.append((row['code'],row['name'],row['year'],row['report_date'],row['divi'],row['shares']))
    cur.executemany('insert into distribute (code,name,year,report_date,divi,shares) values(%s,%s,%s,%s,%s,%s)',values)
    conn.commit()
    cur.close()
    conn.close()
#更新predict
def updatepredict():
    predictdatalist=ts.forecast_data(2014,1)
    predictdata=pd.DataFrame(predictdatalist)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    values=[]
    for index,row in predictdata.iterrows():
        values.append((row['code'],row['name'],row['type'],row['report_date'],row['pre_eps'],row['range']))
    cur.executemany("insert into predict20141 (code,name,type,report_date,pre_eps,ran) values(%s,%s,%s,%s,%s,%s)",values)
    conn.commit()
    cur.close()
    conn.close()
#更新holds
def updateholds():
    holdsdatalist=ts.fund_holdings(2014,2,10,1)
    holdsdata=pd.DataFrame(holdsdatalist)
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    values=[]
    for index,row in holdsdata.iterrows():
        values.append((row['code'],row['name'],row['date'],row['nums'],row['nlast'],row['count'],row['clast'],row['amount'],row['ratio']))
    cur.executemany('insert into holds20142 (code,name,date,nums,nlast,count,clast,amount,ratio) values(%s,%s,%s,%s,%s,%s,%s,%s,%s)',values)
    conn.commit()
    cur.close()
    conn.close()
#更新各支股票历史信息
def updateStockone():
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    cur.execute('select code from mainlist')
    stus = cur.fetchall()
    code=''
    for stu in stus:
        code=stu[0]
        selectstr='select max(date) from stock_'+code
        cur.execute(selectstr)
        Maxdate = cur.fetchall()
        if Maxdate==():
            stockonelist=ts.get_hist_data(code)
            stockone=pd.DataFrame(stockonelist)
            values=[]
            for index,row in stockone.iterrows():
                values.append((index,row['open'],row['high'],row['close'],row['low'],row['volume'],row['price_change'],row['p_change'],\
                               row['ma5'],row['ma10'],row['ma20'],row['v_ma5'],row['v_ma10'],row['v_ma20'],row['turnover']))
            insertstr='insert into stock_'+code+' (date,open,high,close,low,volume,price_change,p_change,ma5,ma10,ma20,v_ma5,v_ma10,v_ma20,turnover) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'
            cur.executemany(insertstr,values)
            conn.commit()
        else:
            date=''
            for maxD in Maxdate:
                date=maxD[0]
            date = date+ datetime.timedelta(1)
            now=time.strftime("%Y-%m-%d",time.localtime(time.time()))
            t=date.strftime('%Y-%m-%d')
            if t!=now:
                stockonelist=ts.get_hist_data(code,t,now)
                stockone=pd.DataFrame(stockonelist)
                values=[]
                for index,row in stockone.iterrows():
                    values.append((index,row['open'],row['high'],row['close'],row['low'],row['volume'],row['price_change'],row['p_change'],\
                                   row['ma5'],row['ma10'],row['ma20'],row['v_ma5'],row['v_ma10'],row['v_ma20'],row['turnover']))
                insertstr='insert into stock_'+code+' (date,open,high,close,low,volume,price_change,p_change,ma5,ma10,ma20,v_ma5,v_ma10,v_ma20,turnover) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'
                cur.executemany(insertstr,values)
                conn.commit()
    cur.close()
    conn.close()
#更新stockbigchange
def updatestockbigchange():
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    cur.execute('select code from mainlist')
    stus = cur.fetchall()
    now=time.strftime("%Y-%m-%d",time.localtime(time.time()))
    code=''
    for stu in stus:
        code=stu[0]
        stockbigchangelist=ts.get_sina_dd(code,now)
        stockbigchange=pd.DataFrame(stockbigchangelist)
        if stockbigchange.size!=0:
            cur.execute("delete from stockbigchange_"+code)
            values=[]
            for index,row in stockbigchange.iterrows():
                values.append((row['time'],row['price'],row['volume'],row['preprice'],row['type']))
            insertstr='insert into stockbigchange_'+code+' (time,price,volume,preprice,type) values(%s,%s,%s,%s,%s)'
            cur.executemany(insertstr,values)
            conn.commit()
    cur.close()
    conn.close()
#更新specialnews
def updatespecialnews():
    conn= ms.connect(host='localhost',port = 3306,user='root', passwd='123456',db ='investment',charset="utf8")
    cur = conn.cursor()
    cur.execute('select code from mainlist')
    stus = cur.fetchall()
    code=''
    for stu in stus:
        code=stu[0]
        specialnewsdatalist=ts.get_notices(code)
        specialnewsdata=pd.DataFrame(specialnewsdatalist)
        values=[]
        print code
        for index,row in specialnewsdata.iterrows():
            values.append((row['title'].encode("utf-8"),row['type'].encode("utf-8"),row['date'].encode("utf-8"),row['url']))
        cur.execute('delete from specialnews_'+code)
        insertstr='insert into specialnews_'+code+' (title,type,date,url) values(%s,%s,%s,%s)'
        cur.executemany(insertstr,values)
        conn.commit()
    cur.close()
    conn.close()
if __name__ == '__main__':
    print "Start_updatenews : %s" % time.ctime()
    updatenews()
    print "Start_updateMarketlist : %s" % time.ctime()
    updateMarketlist()
    print "Start_updatestocklist : %s" % time.ctime()
    updatestocklist()
    print "Start_updateMarketone : %s" % time.ctime()
    updateMarketone()
    print "Start_updateStockone : %s" % time.ctime()
    updateStockone()
    print "Start_updatestockbigchange : %s" % time.ctime()
    updatestockbigchange()
    print "Start_updatespecialnews : %s" % time.ctime()
    updatespecialnews()
    print "end : %s" % time.ctime()
    pass
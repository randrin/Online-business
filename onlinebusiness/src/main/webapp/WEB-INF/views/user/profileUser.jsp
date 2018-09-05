<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container" style="padding-top: 30px;">
        <div class="col-md-12 bhoechie-tab-container">
            <div class="col-md-2 bhoechie-tab-menu">
              <div class="list-group">
                <a href="${contextRoot}/user/userInformations" class="list-group-item text-center" id="infosUser">
                  <h4 class="glyphicon glyphicon-home"></h4>
                  <br/><b>My Personals Informations</b>
                </a>
                <a href="${contextRoot}/user/address" class="list-group-item text-center">
                  <h4 class="glyphicon glyphicon-plane"></h4>
                  <br/><b>List Address</b>
                </a>
                <a href="${contextRoot}/user/advantages" class="list-group-item text-center">
                  <h4 class="glyphicon glyphicon-road"></h4>
                  <br/><b>My Advantages</b>
                </a>
                <a href="${contextRoot}/user/setting" class="list-group-item text-center">
                  <h4 class="glyphicon glyphicon-cutlery"></h4>
                  <br/><b>Change Password</b>
                </a>
              </div>
            </div>
            <div class="col-md-10 bhoechie-tab">
                <!-- flight section -->
                <div class="bhoechie-tab-content active">
                    <section>
                      <h1 class="glyphicon glyphicon-plane" style="font-size:14em;color:#55518a"></h1>
                      <h2 style="margin-top: 0;color:#55518a">Cooming Soon</h2>
                      <h3 style="margin-top: 0;color:#55518a">${profileUserModel.fullName}</h3>
                      <h3 style="margin-top: 0;color:#55518a">${profileUserModel.postalCode}</h3>
                      <h3 style="margin-top: 0;color:#55518a">${profileUserModel.state}</h3>
                    </section>
                </div>
                <!-- train section -->
                <div class="bhoechie-tab-content">
                    <section>
                      <h1 class="glyphicon glyphicon-road" style="font-size:12em;color:#55518a"></h1>
                      <h2 style="margin-top: 0;color:#55518a">Cooming Soon</h2>
                      <h3 style="margin-top: 0;color:#55518a">${profileUserModel.fullName}</h3>
                      <h3 style="margin-top: 0;color:#55518a">${profileUserModel.postalCode}</h3>
                      <h3 style="margin-top: 0;color:#55518a">${profileUserModel.state}</h3>
                    </section>
                </div>
    
                <!-- hotel search -->
                <div class="bhoechie-tab-content">
                    <section>
                      <h1 class="glyphicon glyphicon-home" style="font-size:12em;color:#55518a"></h1>
                      <h2 style="margin-top: 0;color:#55518a">Cooming Soon</h2>
                      <h3 style="margin-top: 0;color:#55518a">${profileUserModel.fullName}</h3>
                      <h3 style="margin-top: 0;color:#55518a">${profileUserModel.postalCode}</h3>
                      <h3 style="margin-top: 0;color:#55518a">${profileUserModel.state}</h3>
                    </section>
                </div>
                <div class="bhoechie-tab-content">
                    <section>
                      <h1 class="glyphicon glyphicon-cutlery" style="font-size:12em;color:#55518a"></h1>
                      <h2 style="margin-top: 0;color:#55518a">Cooming Soon</h2>
                      <h3 style="margin-top: 0;color:#55518a">${profileUserModel.fullName}</h3>
                      <h3 style="margin-top: 0;color:#55518a">${profileUserModel.postalCode}</h3>
                      <h3 style="margin-top: 0;color:#55518a">${profileUserModel.state}</h3>
                    </section>
                </div>
            </div>
        </div>
</div>
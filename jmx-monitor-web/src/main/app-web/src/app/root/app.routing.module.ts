import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

export const routers: Routes = [
  // { path: '', redirectTo: 'jmx-connection', pathMatch: 'full'},
  { path: '', loadChildren: 'app/jmx-connection/jmx.connection.module#JmxConnectionModule'},
  { path: 'jmx-agent', loadChildren: 'app/jmx-agent/jmx.agent.module#JmxAgentModule'},
  // { path: 'jmx-agent', loadChildren: 'app/jmx-agent/jmx.agent.module#JmxAgentModule'},

  // { path: 'crisis', loadChildren: 'app/crisis/crisis.module#CrisisModule' },
  // { path: 'crisis', loadChildren: 'app/crisis/crisis.module#CrisisModule'},
  // { path: 'contact', loadChildren: 'app/crisis/crisis.module#CrisisModule'},
  // { path: 'heroes', loadChildren: 'app/hero/hero.module#HeroModule' }
  { path: 'jmx-connection', loadChildren: 'app/jmx-connection/jmx.connection.module#JmxConnectionModule' },

];

@NgModule({
  imports: [ RouterModule.forRoot(routers/*,
    { enableTracing: true }*/)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

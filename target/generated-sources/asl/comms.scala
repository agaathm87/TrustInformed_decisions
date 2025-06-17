package asl
 import _root_.scala.collection.mutable.HashMap

 import _root_.akka.actor.typed.{ActorRef, Behavior, SupervisorStrategy}
 import _root_.akka.actor.typed.scaladsl.{ActorContext, Behaviors, Routers}
 import java.util.logging.Logger
 import _root_.scala.util.Failure
 import _root_.scala.util.Success
 import _root_.akka.util.Timeout
 import _root_.scala.concurrent.duration._
 import _root_.akka.actor.typed.scaladsl.AskPattern._
 import _root_.scala.language.implicitConversions
 import _root_.scala.concurrent.{Await, Future}
 import _root_.scala.jdk.CollectionConverters._
 import std.converters._

 import scala.util.Random
 import bb._
 import infrastructure._
 import bb.expstyla.exp._
 import std.{AgentCommunicationLayer, DefaultCommunications}

 class comms  (coms: AgentCommunicationLayer = new  DefaultCommunications,
                                     beliefBaseFactory: IBeliefBaseFactory = new StylaBeliefBaseFactory)
                      extends IntentionalAgentFactory {


 object Intention {

       def apply(p_executionContext: ExecutionContext): Behavior[ISubGoalMessage] = Behaviors.setup { context =>

         Behaviors.receive {
         (context, message) =>

          implicit val executionContext = p_executionContext.copy(intention = context, src = message.source)

         message match {
            case SubGoalMessage(_,_,r) =>
               message.goal match {

                   case comms.this.adopt_achievement_send_beliefs_0 =>
                     comms.this.adopt_achievement_send_beliefs_0.execute(message.params.asInstanceOf[Parameters])

                   case comms.this.adopt_achievement_send_belief1_1 =>
                     comms.this.adopt_achievement_send_belief1_1.execute(message.params.asInstanceOf[Parameters])

                   case comms.this.adopt_achievement_send_belief2_2 =>
                     comms.this.adopt_achievement_send_belief2_2.execute(message.params.asInstanceOf[Parameters])

                   case comms.this.adopt_achievement_send_belief3_3 =>
                     comms.this.adopt_achievement_send_belief3_3.execute(message.params.asInstanceOf[Parameters])

                   case comms.this.adopt_achievement_send_belief4_4 =>
                     comms.this.adopt_achievement_send_belief4_4.execute(message.params.asInstanceOf[Parameters])

                   case comms.this.adopt_achievement_send_belief5_5 =>
                     comms.this.adopt_achievement_send_belief5_5.execute(message.params.asInstanceOf[Parameters])


           case _ =>
             context.log.error("This actor can not handle goal of type {}", message.goal)
         }
           r match {
                 case a : AkkaMessageSource => 
                   a.src ! IntentionDoneMessage(AkkaMessageSource(executionContext.agent.self))
                 case DummyMessageSource(_) => 
                   context.log.error("Intention Done!")
               }

               Behaviors.same
             case InitEndMessage(r) =>
               Behaviors.stopped
       }
      }
     }
     }

 override def agentBuilder: Agent = new Agent()
 class Agent extends IAgent {

         override def agent_type: String = "comms"

         var vars = VarMap()

         def initGoals()(implicit executionContext: ExecutionContext) = List[StructTerm](
         )

         def initBeliefs()(implicit executionContext: ExecutionContext) = List[StructTerm](
                     StructTerm("threshold",Seq[GenericTerm](vars("T")))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("offer",Seq[GenericTerm](vars("Agent"),vars("NewPlan"),vars("OldPlan"),vars("Label"))),StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("offer",Seq[GenericTerm]()),vars("Agent"),vars("NewPlan"),vars("OldPlan"),vars("Label"))),StructTerm("threshold",Seq[GenericTerm](vars("T"))))),StructTerm(">",Seq[GenericTerm](vars("Y"),vars("T")))))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("reject",Seq[GenericTerm](vars("Agent"),vars("Offer"),vars("Value"))),StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("reject",Seq[GenericTerm]()),vars("Agent"),vars("Offer"),vars("Value"))),StructTerm("threshold",Seq[GenericTerm](vars("T"))))),StructTerm(">",Seq[GenericTerm](vars("Y"),vars("T")))))))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("phi",Seq[GenericTerm](vars("Plan"),vars("Value"),vars("X"))),StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("belief",Seq[GenericTerm](vars("Y"),StructTerm("phi",Seq[GenericTerm]()),vars("Plan"),vars("Value"),vars("X"))),StructTerm("threshold",Seq[GenericTerm](vars("T"))))),StructTerm(">",Seq[GenericTerm](vars("Y"),vars("T")))))))


         )

         def planApplicabilities()(implicit executionContext: ExecutionContext) = List[StructTerm](

                 )



      def apply(name: String, yellowPages: IYellowPages, MAS: ActorRef[IMessage], parent: IMessageSource): Behavior[IMessage] = {
           Behaviors.setup { context =>
             val yp: IYellowPages = yellowPages
             val bb: IBeliefBase[GenericTerm] = beliefBaseFactory()
             implicit val executionContext: ExecutionContext = ExecutionContext(
                            name = name,
                            agentType = agent_type,
                            agent = context,
                            yellowPages = yp,
                            beliefBase = bb,
                            logger = context.log,
                            goalParser = GoalParser,
                            parent = parent
                          )
             bb.assert(initBeliefs)
             bb.assert(planApplicabilities)

         val initiator = context.spawn(Intention(executionContext), "initiator")

         MAS ! ReadyMessage(context.self)
         Behaviors.receive {
           (context, message) =>
             message match {
               case StartMessage() =>


                 implicit val timeout: Timeout = 99999.seconds
                 implicit val ec = context.executionContext
                 implicit val scheduler = context.system.scheduler


                 //              initGoals.foreach( tuple => initiator ! SubGoalMessage(tuple._1,tuple._2,context.self))
                 initGoals.foreach(struct => {


                   val result: Future[IMessage] = initiator.ask[IMessage](ref => {
                     val subGoal = GoalParser.create_goal_message(struct, AkkaMessageSource(ref))
                     if (subGoal.isDefined)
                       subGoal.get
                     else
                       throw new RuntimeException(s"No plan for initial goal $struct")
                     }
                   )


                   //result.onComplete {
                   //  case Success(IntentionDoneMessage(r)) => IntentionDoneMessage(r)
                   //  case Failure(_) => IntentionErrorMessage(src = null)
                   //}

                   //Await.result(result, timeout.duration)

                   val res = Await.result(result, timeout.duration)

                   if(!res.isInstanceOf[IntentionDoneMessage]) {
                     throw new RuntimeException(s"Issue with initial goal $struct")
                     context.system.terminate()
                   }

                   //                context.ask[ISubGoalMessage, IMessage](initiator, ref => SubGoalMessage(tuple._1, tuple._2,name, ref)) {
                   //                  case Success(IntentionDoneMessage(_, _)) => IntentionDoneMessage()
                   //                  case Failure(_) => IntentionErrorMessage()
                   //                }
                 }
                 )

                 initiator ! InitEndMessage(context.self)
                 normal_behavior(MAS)

               //            case InitEndMessage(_) =>
               //              context.log.debug(f"$name: I have started, switching behavior")
               //              normal_behavior()
             }

         }
       }
     }

     def normal_behavior(MAS: ActorRef[IMessage])(implicit executionContext: ExecutionContext): Behavior[IMessage] = {
       Behaviors.setup { context =>

         val pool = Routers.pool(poolSize = 8)(
           Behaviors.supervise(Intention(executionContext)).onFailure[Exception](SupervisorStrategy.restart))

         val router = context.spawn(pool, "intention-pool")
         //MAS ! ReadyMessage(context.self)
         Behaviors.receive {
           (context, message) =>
             message match {
               case IntentionDoneMessage(s) =>
                 context.log.debug(f"${executionContext.name}: an intention was done by $s")
               case IntentionErrorMessage(c,s) =>
                 context.log.debug(f"${executionContext.name}: an intention was done by $s: $c")
               case SubGoalMessage(_, _, _) =>
                 router ! message.asInstanceOf[SubGoalMessage]
               case GoalMessage(m, ref) =>
                 m match {
                   case t: StructTerm =>
                     val subGoal = GoalParser.create_goal_message(t, ref)

                     if (subGoal.isDefined)
                       context.self ! subGoal.get
                     else
                       ref.asInstanceOf[AkkaMessageSource].src ! IntentionErrorMessage(NoPlanMessage(),AkkaMessageSource(executionContext.agent.self))


                 }

                case AskMessage(m, ref) =>
                                m match {
                                  case t: StructTerm =>
                                    val subGoal = GoalParser.create_test_message(t, ref)

                                    if (subGoal.isDefined)
                                      context.self ! subGoal.get
                                    else
                                      ref.asInstanceOf[AkkaMessageSource].src ! IntentionErrorMessage(NoPlanMessage(),AkkaMessageSource(executionContext.agent.self))
                                }
             case BeliefMessage(m, ref) =>
                  m match {
                    case t: StructTerm =>
                    if(executionContext.beliefBase.assertOne(t)) {
                      val subGoal = GoalParser.create_belief_message(t, ref)

                      if (subGoal.isDefined)
                        context.self ! subGoal.get
                    }
                  }

              case UnBeliefMessage(m, ref) =>
                   m match {
                     case t: StructTerm =>
                     if(executionContext.beliefBase.retractOne(t)) {
                       val subGoal = GoalParser.create_unbelief_message(t, ref)

                       if (subGoal.isDefined)
                         context.self ! subGoal.get
                     }
                   }
             }
             Behaviors.same
         }
       }
     }
   }



   object GoalParser extends IAgentGoalParser {
        override def create_goal_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                   if(t.matchOnlyFunctorAndArity("send_beliefs",0)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_beliefs_0, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_belief1",1)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_belief1_1, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_belief2",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_belief2_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_belief3",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_belief3_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_belief4",4)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_belief4_4, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("send_belief5",5)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_send_belief5_5, args, ref))
                                   } else   {
                    Option.empty[SubGoalMessage]
                    }

                }

        override def create_belief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                         {
                    Option.empty[SubGoalMessage]
                    }

                }

         override def create_test_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                 {
                            Option.empty[SubGoalMessage]
                            }
                        }
          override def create_unbelief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                          {
                                     Option.empty[SubGoalMessage]
                                     }
                                 }



        }


      object adopt_achievement_send_beliefs_0 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("TrustorName" -> StringTerm("trustor"))
                                          adopt_achievement_send_belief1_1.execute(Parameters(List( vars("TrustorName")  )))


                     }


      }

      object adopt_achievement_send_belief1_1 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "TrustorName" -> params.l_params(0))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                               val ex_L95078 = executionContext.beliefBase.bufferedQuery( StructTerm("message",Seq[GenericTerm](vars("L95078"),vars("B"))) )
                                               while (ex_L95078.hasNext) {
                                                   val sol_L95078 = ex_L95078.next
                                                   if(sol_L95078.result) {
                                                   vars += ("A" -> sol_L95078.bindings("L95078").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_send_belief2_2.execute(Parameters(List( vars("TrustorName") , vars("A")  )))

                                                   }
                                               }
                                           vars -= ("A")
                                               val ex_L22274 = executionContext.beliefBase.bufferedQuery( StructTerm("message",Seq[GenericTerm](vars("L22274"),vars("B1"),vars("C1"))) )
                                               while (ex_L22274.hasNext) {
                                                   val sol_L22274 = ex_L22274.next
                                                   if(sol_L22274.result) {
                                                   vars += ("A1" -> sol_L22274.bindings("L22274").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_send_belief2_2.execute(Parameters(List( vars("TrustorName") , vars("A1")  )))

                                                   }
                                               }
                                           vars -= ("A1")
                                               val ex_L72724 = executionContext.beliefBase.bufferedQuery( StructTerm("message",Seq[GenericTerm](vars("L72724"),vars("B2"),vars("C2"),vars("D2"))) )
                                               while (ex_L72724.hasNext) {
                                                   val sol_L72724 = ex_L72724.next
                                                   if(sol_L72724.result) {
                                                   vars += ("A2" -> sol_L72724.bindings("L72724").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_send_belief2_2.execute(Parameters(List( vars("TrustorName") , vars("A2")  )))

                                                   }
                                               }
                                           vars -= ("A2")
                                               val ex_L67538 = executionContext.beliefBase.bufferedQuery( StructTerm("message",Seq[GenericTerm](vars("L67538"),vars("B3"),vars("C3"),vars("D3"),vars("E3"))) )
                                               while (ex_L67538.hasNext) {
                                                   val sol_L67538 = ex_L67538.next
                                                   if(sol_L67538.result) {
                                                   vars += ("A3" -> sol_L67538.bindings("L67538").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_send_belief2_2.execute(Parameters(List( vars("TrustorName") , vars("A3")  )))

                                                   }
                                               }
                                           vars -= ("A3")


                     }


      }

      object adopt_achievement_send_belief2_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "TrustorName" -> params.l_params(0))
                          vars +=(   "A" -> params.l_params(1))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                               val ex_L21426 = executionContext.beliefBase.bufferedQuery( StructTerm("message",Seq[GenericTerm](vars("A"),vars("L21426"))) )
                                               while (ex_L21426.hasNext) {
                                                   val sol_L21426 = ex_L21426.next
                                                   if(sol_L21426.result) {
                                                   vars += ("B" -> sol_L21426.bindings("L21426").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("TrustorName"),StructTerm("belief",Seq[GenericTerm](vars("Self"),vars("A"),vars("B"))))))

                                                   }
                                               }
                                           vars -= ("B")
                                               val ex_L55237 = executionContext.beliefBase.bufferedQuery( StructTerm("message",Seq[GenericTerm](vars("A"),vars("L55237"),vars("C1"))) )
                                               while (ex_L55237.hasNext) {
                                                   val sol_L55237 = ex_L55237.next
                                                   if(sol_L55237.result) {
                                                   vars += ("B1" -> sol_L55237.bindings("L55237").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_send_belief3_3.execute(Parameters(List( vars("TrustorName") , vars("A") , vars("B1")  )))

                                                   }
                                               }
                                           vars -= ("B1")
                                               val ex_L64904 = executionContext.beliefBase.bufferedQuery( StructTerm("message",Seq[GenericTerm](vars("A"),vars("L64904"),vars("C2"),vars("D2"))) )
                                               while (ex_L64904.hasNext) {
                                                   val sol_L64904 = ex_L64904.next
                                                   if(sol_L64904.result) {
                                                   vars += ("B2" -> sol_L64904.bindings("L64904").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_send_belief3_3.execute(Parameters(List( vars("TrustorName") , vars("A") , vars("B2")  )))

                                                   }
                                               }
                                           vars -= ("B2")
                                               val ex_L88987 = executionContext.beliefBase.bufferedQuery( StructTerm("message",Seq[GenericTerm](vars("A"),vars("L88987"),vars("C3"),vars("D3"),vars("E3"))) )
                                               while (ex_L88987.hasNext) {
                                                   val sol_L88987 = ex_L88987.next
                                                   if(sol_L88987.result) {
                                                   vars += ("B3" -> sol_L88987.bindings("L88987").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_send_belief3_3.execute(Parameters(List( vars("TrustorName") , vars("A") , vars("B3")  )))

                                                   }
                                               }
                                           vars -= ("B3")


                     }


      }

      object adopt_achievement_send_belief3_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "TrustorName" -> params.l_params(0))
                          vars +=(   "A" -> params.l_params(1))
                          vars +=(   "B" -> params.l_params(2))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                               val ex_L94426 = executionContext.beliefBase.bufferedQuery( StructTerm("message",Seq[GenericTerm](vars("A"),vars("B"),vars("L94426"))) )
                                               while (ex_L94426.hasNext) {
                                                   val sol_L94426 = ex_L94426.next
                                                   if(sol_L94426.result) {
                                                   vars += ("C" -> sol_L94426.bindings("L94426").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("TrustorName"),StructTerm("belief",Seq[GenericTerm](vars("Self"),vars("A"),vars("B"),vars("C"))))))

                                                   }
                                               }
                                           vars -= ("C")
                                               val ex_L87417 = executionContext.beliefBase.bufferedQuery( StructTerm("message",Seq[GenericTerm](vars("A"),vars("B"),vars("L87417"),vars("D1"))) )
                                               while (ex_L87417.hasNext) {
                                                   val sol_L87417 = ex_L87417.next
                                                   if(sol_L87417.result) {
                                                   vars += ("C1" -> sol_L87417.bindings("L87417").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_send_belief4_4.execute(Parameters(List( vars("TrustorName") , vars("A") , vars("B") , vars("C1")  )))

                                                   }
                                               }
                                           vars -= ("C1")
                                               val ex_L84224 = executionContext.beliefBase.bufferedQuery( StructTerm("message",Seq[GenericTerm](vars("A"),vars("B"),vars("L84224"),vars("D2"),vars("E2"))) )
                                               while (ex_L84224.hasNext) {
                                                   val sol_L84224 = ex_L84224.next
                                                   if(sol_L84224.result) {
                                                   vars += ("C2" -> sol_L84224.bindings("L84224").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_send_belief4_4.execute(Parameters(List( vars("TrustorName") , vars("A") , vars("B") , vars("C2")  )))

                                                   }
                                               }
                                           vars -= ("C2")


                     }


      }

      object adopt_achievement_send_belief4_4 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "TrustorName" -> params.l_params(0))
                          vars +=(   "A" -> params.l_params(1))
                          vars +=(   "B" -> params.l_params(2))
                          vars +=(   "C" -> params.l_params(3))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                               val ex_L59005 = executionContext.beliefBase.bufferedQuery( StructTerm("message",Seq[GenericTerm](vars("A"),vars("B"),vars("C"),vars("L59005"))) )
                                               while (ex_L59005.hasNext) {
                                                   val sol_L59005 = ex_L59005.next
                                                   if(sol_L59005.result) {
                                                   vars += ("D" -> sol_L59005.bindings("L59005").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("TrustorName"),StructTerm("belief",Seq[GenericTerm](vars("Self"),vars("A"),vars("B"),vars("C"),vars("D"))))))

                                                   }
                                               }
                                           vars -= ("D")
                                               val ex_L11446 = executionContext.beliefBase.bufferedQuery( StructTerm("belief",Seq[GenericTerm](vars("A"),vars("B"),vars("C"),vars("L11446"),vars("E1"))) )
                                               while (ex_L11446.hasNext) {
                                                   val sol_L11446 = ex_L11446.next
                                                   if(sol_L11446.result) {
                                                   vars += ("D1" -> sol_L11446.bindings("L11446").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_send_belief5_5.execute(Parameters(List( vars("TrustorName") , vars("A") , vars("B") , vars("C") , vars("D1")  )))

                                                   }
                                               }
                                           vars -= ("D1")


                     }


      }

      object adopt_achievement_send_belief5_5 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "TrustorName" -> params.l_params(0))
                          vars +=(   "A" -> params.l_params(1))
                          vars +=(   "B" -> params.l_params(2))
                          vars +=(   "C" -> params.l_params(3))
                          vars +=(   "D" -> params.l_params(4))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                               val ex_L19597 = executionContext.beliefBase.bufferedQuery( StructTerm("message",Seq[GenericTerm](vars("A"),vars("B"),vars("C"),vars("D"),vars("L19597"))) )
                                               while (ex_L19597.hasNext) {
                                                   val sol_L19597 = ex_L19597.next
                                                   if(sol_L19597.result) {
                                                   vars += ("E" -> sol_L19597.bindings("L19597").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("TrustorName"),StructTerm("belief",Seq[GenericTerm](vars("Self"),vars("A"),vars("B"),vars("C"),vars("D"),vars("E"))))))

                                                   }
                                               }
                                           vars -= ("E")


                     }


      }





 }
object comms_companion { 
   def create() = new comms().agentBuilder 
   def create(in_coms : AgentCommunicationLayer) = new comms(coms = in_coms).agentBuilder 
   def create(in_beliefBaseFactory: IBeliefBaseFactory) = new comms(beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
   def create(in_coms : AgentCommunicationLayer, in_beliefBaseFactory: IBeliefBaseFactory) = new comms(coms = in_coms, beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
} 
